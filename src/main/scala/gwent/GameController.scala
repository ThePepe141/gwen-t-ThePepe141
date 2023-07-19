package cl.uchile.dcc
package gwent

import gwent.states.{BeforeMatchState, GameState}
import gwent.board.{Board, CardLibrary}
import gwent.cards.Card
import gwent.players.{CpuPlayer, HumanPlayer}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

abstract class GameController {
  
  var gameState: GameState = new BeforeMatchState(this)
  var humanPlayer: HumanPlayer = _
  var cpuPlayer: CpuPlayer = _
  var theBoard: Board = _
  val library = new CardLibrary
  var humanStartMatch: Boolean = _
  var humanName: String = _
  var humanDeck: ListBuffer[Card] = _
  var cpuDeck: ListBuffer[Card] = _
  var firstMatch: Boolean = true
  var keepDecks: Boolean = false
  
  trigger()
  
  //GameState trigger functions ---------------------------------------

  /** A functions that triggers the action method of the current gameState.
   */
  def trigger(): Unit = {
    gameState.action()
  }

  /** A function trigger by BeforeMatchState.action()
   */
  def setPlayers(): Unit = {
    if (firstMatch){
      //Choose the human name
      println("Hello Human player, please choose your name")
      val name = readLine()
      humanPlayer = new HumanPlayer(name, ListBuffer[Card]())
      cpuPlayer = new CpuPlayer(ListBuffer[Card]())
      println(s"Thank you ${humanPlayer.getUsername}")
    }
    else if (!firstMatch && keepDecks){
      humanPlayer = new HumanPlayer(humanName, humanDeck)
      cpuPlayer = new CpuPlayer(cpuDeck)
    }
    else{
      humanPlayer = new HumanPlayer(humanName, ListBuffer[Card]())
      cpuPlayer = new CpuPlayer(ListBuffer[Card]())
    }
  }

  /** A function trigger by BeforeMatchState.action()
   */
  def matchSettings(): Unit = {
    //Build the human player deck
    println("Deck library")
    library.showLibrary()
    var a = readLine().toInt
    while (a != -1 || humanPlayer.deckSize < 25) {
      if (a == -1) {
        println("Your deck does not have the minimum of cards")
      }
      else if (a != 1 && a != 2 && a != 3 && a != 4) {
        println("Invalid set number")
      }
      else {
        println("Which card do you want (write the index)")
        val b = readLine().toInt
        if (a == 1) {
          humanPlayer.addToDeck(library.closeCombatCards(b))
        }
        else if (a == 2) {
          humanPlayer.addToDeck(library.rangedCombatCards(b))
        }
        else if (a == 3) {
          humanPlayer.addToDeck(library.siegeCombatCards(b))
        }
        else if (a == 4) {
          humanPlayer.addToDeck(library.weatherCards(b))
        }
        println("Your current deck")
        showDeck()
      }
      println("Write the number of the set you want to pick for or -1 to finish")
      a = readLine().toInt
    }
    println("Your deck has been filled")
    showDeck()
    humanDeck = humanPlayer.getDeck
    //Build the machine deck
    println("Please choose your opponent´s deck")
    println("Write the number of the set you want to pick for or -1 to finish")
    var x = readLine().toInt
    while (x != -1 || cpuPlayer.deckSize < 25) {
      if (x == -1) {
        println("Your deck does not have the minimum of cards")
      }
      else if (x != 1 && x != 2 && x != 3 && x != 4) {
        println("Invalid set number")
      }
      else {
        println("Which card do you want (write the index)")
        val b = readLine().toInt
        if (x == 1) {
          cpuPlayer.addToDeck(library.closeCombatCards(b))
        }
        else if (x == 2) {
          cpuPlayer.addToDeck(library.rangedCombatCards(b))
        }
        else if (x == 3) {
          cpuPlayer.addToDeck(library.siegeCombatCards(b))
        }
        else if (x == 4) {
          cpuPlayer.addToDeck(library.weatherCards(b))
        }
        println("Your current deck")
        for (card <- cpuPlayer.getDeck) {
          println(card.toString)
        }
      }
      println("Write the number of the set you want to pick for or -1 to finish")
      x = readLine().toInt
    }
    println("Your opponent´s deck has been filled")
    cpuDeck = cpuPlayer.getDeck
  }

  /** A function trigger by BeforeMatchState.action()
   */
  def setBoard(): Unit = {
    //Create the Board
    theBoard = new Board(humanPlayer, cpuPlayer)
    //Board settings
    theBoard.assignSections
    theBoard.startMatch
    //Switch gameState
    gameState.toBeginRoundState()
  }

  /** A function trigger by BeginRoundState.action()
   */
  def roundSettings(): Unit = {
    //The round has begun
    theBoard.startRound
    if (theBoard.round == 1) {

      if (theBoard.coin == 0) {
        //Human player begin
        humanStartMatch = true
        gameState.toInTurnState()
      }
      else {
        //Cpu player begin
        humanStartMatch = false
        gameState.toWaitingTurnState()
      }
    }
    else {
      humanStartMatch = !humanStartMatch
      if (humanStartMatch) {
        //Cpu player begun last turn, it´s human player´s turn
        gameState.toInTurnState()
      }
      else {
        //Human player begun last turn, it´s cpu player´s turn
        gameState.toWaitingTurnState()
      }
    }
  }

  /** A function trigger by InTurnState.action()
   */
  def humanMove(): Unit = {
    showBoard()
    showHand()
    println("Choose 1 to play a card, choose 2 to pass")
    var choice = readLine().toInt
    while (choice!=1 && choice!=2){
      println("Wrong input, choose 1 to play a card, choose 2 to pass")
      choice = readLine().toInt
    }
    if (choice==1){
      humanPlayer.playCard
      theBoard.updateScores
      if (humanPlayer.getHand.isEmpty){
        gameState.toStandByState()
      }
      else{
        gameState.toWaitingTurnState()
      }
    }
    else if (choice == 2){
      gameState.toStandByState()
    }
  }

  /** A function trigger by WaitingTurnState.action()
   */
  def machineMove(): Unit = {
    if (!cpuPlayer.pass){
      cpuPlayer.playCard
      theBoard.updateScores
      if (cpuPlayer.getHand.isEmpty) {
        machinePass()
        gameState.toInTurnState()
      }
      else {
        gameState.toInTurnState()
      }
    }
    else{
      gameState.toInTurnState()
    }
  }

  /** A function trigger by StandByState.action()
   */
  def humanPass(): Unit = {
    humanPlayer.pass = true
    println(s"${humanPlayer.getUsername} passed the round")
  }

  /** A function that defines when the CpuPlayer pass de Round
   */
  def machinePass(): Unit = {
    cpuPlayer.pass = true
    println(s"${cpuPlayer.getUsername} has passed the round")
  }

  /** A function trigger by StandByState.action()
   */
  def endingRound(): Unit = {
    if (cpuPlayer.pass && humanPlayer.pass){
      gameState.toEndRoundState()
    }
    else{
      while(theBoard.Front.getTotalPower>=theBoard.Back.getTotalPower && cpuPlayer.getHand.nonEmpty){
        cpuPlayer.playCard
        theBoard.updateScores
      }
      machinePass()
      endingRound()
    }
  }

  /** A function trigger by EndRoundState.action()
   */
  def definingWinner(): Unit = {
    theBoard.assignPoints
    if (theBoard.FrontPoints(theBoard.round)>theBoard.BackPoints(theBoard.round)){
      cpuPlayer.roundLost
      println(s"${cpuPlayer.getUsername} loose the round")
    }
    else if(theBoard.FrontPoints(theBoard.round)<theBoard.BackPoints(theBoard.round)){
      humanPlayer.roundLost
      println(s"${humanPlayer.getUsername} loose the round")
    }
    else{
      humanPlayer.roundLost
      cpuPlayer.roundLost
      println("The match end in draw")
    }
    if (humanPlayer.isDefeated && cpuPlayer.isDefeated){ 
      println("The match end in draw")
      gameState.toAfterMatchState()
    }
    else if (humanPlayer.isDefeated){
      println(s"${cpuPlayer.getUsername} win the match")
      gameState.toAfterMatchState()
    }
    else if (cpuPlayer.isDefeated) {
      println(s"${humanPlayer.getUsername} win the match")
      gameState.toAfterMatchState()
    }
    else{
      humanPlayer.pass = false
      cpuPlayer.pass = false
      theBoard.clearBoard
      gameState.toBeginRoundState()
    }
  }

  /** A function trigger by AfterMatchState.action()
   */
  def postMatch(): Unit = {
    humanPlayer.pass = false
    cpuPlayer.pass = false
    println(s"${humanPlayer.getUsername} points:")
    println(s"Round 1: ${theBoard.FrontPoints.head}, Round 2: ${theBoard.FrontPoints(1)}, Round 3: ${theBoard.FrontPoints(2)}")
    println(s"${cpuPlayer.getUsername} points:")
    println(s"Round 1: ${theBoard.BackPoints.head}, Round 2: ${theBoard.BackPoints(1)}, Round 3: ${theBoard.BackPoints(2)}")
    println("Do you want to play another match? Choose 1 for yes, choose 2 for no")
    val choice = readLine().toInt
    if (choice==1){
      firstMatch = false
      println("Do you want to keep the decks? Choose 1 for yes, choose 2 for no")
      val choice2 = readLine().toInt
      if (choice2 == 1){
        keepDecks = true
      }
      else{
        keepDecks = false
      }
      gameState.toBeforeMatchState()
    }
    else{
      println("GG")
    }
  }
  
  //Show functions -------------------------------------------------

  /** Shows the humanPlayer´s deck.
   */
  def showDeck(): Unit = {
    for (card <- humanPlayer.getDeck){
      println(card.toString)
    }
  }

  /** Shows the humanPlayer´s hand.
   */
  def showHand(): Unit = {
    for (card <- humanPlayer.getHand){
      println(card.toString)
    }
  }

  /** Shows the Board´s rows
   */
  def showBoard(): Unit = {
    println("Cpu side")
    println("Siege Combat Row")
    
  }
}
