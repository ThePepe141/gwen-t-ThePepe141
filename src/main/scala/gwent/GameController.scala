package cl.uchile.dcc
package gwent

import gwent.states.{BeforeMatchState, GameState}
import gwent.board.{Board, CardLibrary}
import gwent.cards.Card
import gwent.players.{CpuPlayer, HumanPlayer}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

class GameController {
  
  var gameState: GameState = new BeforeMatchState(this)
  var humanPlayer: HumanPlayer = _
  var cpuPlayer: CpuPlayer = _
  var theBoard: Board = _
  val library = new CardLibrary
  var humanStartMatch: Boolean = _
  var humanName: String = "Player1"
  var humanDeck: ListBuffer[Card] = ListBuffer[Card]()
  var cpuDeck: ListBuffer[Card] = ListBuffer[Card]()
  var firstMatch: Boolean = true
  var keepDecks: Boolean = false
  val text = "Wrong input, please try again"
  
  
  //GameState trigger functions ---------------------------------------

  /** A functions that triggers the action method of the current gameState.
   */
  def trigger(): Unit = {
    gameState.action()
  }

  /** Sets the matches players, decks and board.
   *
   */
  def matchSettings(): Unit ={
    //Creates players
    humanPlayer = new HumanPlayer(humanName, humanDeck)
    cpuPlayer = new CpuPlayer(cpuDeck)
    println(s"Welcome ${humanPlayer.getUsername}")
    //Create the board
    theBoard = new Board(humanPlayer, cpuPlayer)
    //Board settings
    theBoard.assignSections
    theBoard.startMatch
    //Switch GameState
    gameState.toBeginRoundState()
  }
  

  /** Formally start the round, choose which player goes first.
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

  /** Asks the human player for it´s choice.
   *  Play a Card or pass the Round, updates the Board scores.
   */
  def humanMove(): Unit = {
    showBoard()
    showHand()
    println("Choose 0 to play a card, choose 1 to pass")
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

  /** Play a Card from the cpu Player or make the cpu player pass the Round.
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

  /** Formally make the human player pass the Round.
   */
  def humanPass(): Unit = {
    humanPlayer.pass = true
    println(s"${humanPlayer.getUsername} passed the round")
  }

  /**Formally make the cpu player pass the Round.
   */
  def machinePass(): Unit = {
    cpuPlayer.pass = true
    println(s"${cpuPlayer.getUsername} has passed the round")
  }

  /** Make the cpu player´s choices after human player have pass the round.
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

  /** Formally defines the winner of the Round, and prepares the Board for the next.
   * Change the gems attributes, print the winner, clean the Board.
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

  /** Formally finish the match and prepares the next.
   * Reset player´s pass attributes, print scores, ask player if it wants to play again.
   */
  def postMatch(): Unit = {
    humanPlayer.pass = false
    cpuPlayer.pass = false
    println(s"${humanPlayer.getUsername} points:")
    println(s"Round 1: ${theBoard.FrontPoints.head}, Round 2: ${theBoard.FrontPoints(1)}, Round 3: ${theBoard.FrontPoints(2)}")
    println(s"${cpuPlayer.getUsername} points:")
    println(s"Round 1: ${theBoard.BackPoints.head}, Round 2: ${theBoard.BackPoints(1)}, Round 3: ${theBoard.BackPoints(2)}")
    println("Do you want to play another match? Choose 1 for yes, choose 2 for no")
    var choice = readLine().toInt
    while(choice!=1){
      if (choice==2) println("Are you sure?")
      else println(text)
      choice = readLine().toInt
    }
    firstMatch = false
    println("Do you want to keep the decks? Choose 1 for yes, choose 2 for no")
    var choice2 = readLine().toInt
    while (choice2 != 1 && choice != 2) {
      println(text)
      choice2 = readLine().toInt
    }
    if (choice2 == 1) {
      keepDecks = true
    }
    else {
      keepDecks = false
    }
    gameState.toBeforeMatchState()
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
    theBoard.showBoard
  }
}
