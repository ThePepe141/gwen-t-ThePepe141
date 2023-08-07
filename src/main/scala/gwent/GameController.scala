package cl.uchile.dcc
package gwent

import gwent.states.{BeforeMatchState, GameState}
import gwent.board.{Board, CardLibrary}
import gwent.cards.Card
import gwent.players.{CpuPlayer, HumanPlayer, Player}

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

class GameController {

  //Fill by the class
  var gameState: GameState = new BeforeMatchState(this)
  var humanPlayer: HumanPlayer = _
  var cpuPlayer: CpuPlayer = _
  var thePlayers: ListBuffer[Player] = ListBuffer[Player]()
  var theBoard: Board = _
  var humanStartMatch: Boolean = _
  //Fill by the client
  var humanName: String = "Player1"
  var humanDeck: ListBuffer[Card] = ListBuffer[Card]()
  var cpuDeck: ListBuffer[Card] = ListBuffer[Card]()
  var humanChoice: Int = _
  var humanCardChoice: Int = _
  var machineCardChoice: Int = _
  var rematch = false
  
  
  //GameState trigger functions ---------------------------------------

  /** A functions that triggers the action method of the current gameState.
   */
  def trigger(): Unit = {
    gameState.action()
  }

  /** Set the players and board for the match.
   *
   * @param player1Name The Human player´s username.
   * @param player1Deck The Human player´s deck.
   * @param player2Deck The Cpu player´s deck.
   */
  def matchSettings(player1Name: String, player1Deck: ListBuffer[Card], player2Deck: ListBuffer[Card]): Unit ={
    //Creates players
    humanPlayer = new HumanPlayer(player1Name, player1Deck)
    cpuPlayer = new CpuPlayer(player2Deck)
    thePlayers = ListBuffer[Player](humanPlayer, cpuPlayer)
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
        println(s"${humanPlayer.getUsername} begins the round.")
        humanStartMatch = true
        gameState.toInTurnState()
      }
      else {
        //Cpu player begin
        println(s"${cpuPlayer.getUsername} begins the round.")
        humanStartMatch = false
        gameState.toWaitingTurnState()
      }
    }
    else {
      humanStartMatch = !humanStartMatch
      if (humanStartMatch) {
        //Cpu player begun last turn, it´s human player´s turn
        println(s"${humanPlayer.getUsername} begins the round.")
        gameState.toInTurnState()
      }
      else {
        //Human player begun last turn, it´s cpu player´s turn
        println(s"${cpuPlayer.getUsername} begins the round.")
        gameState.toWaitingTurnState()
      }
    }
  }

  /** Asks the human player for it´s choice.
   *  Play a Card or pass the Round, updates the Board scores.
   */
  def humanMove(choice: Int, cardChoice: Int): Unit = {
    if (choice == 1) {
      humanPlayer.playCard(cardChoice)
      theBoard.updateScores
      if (humanPlayer.getHand.isEmpty) {
        gameState.toStandByState()
      }
      else {
        gameState.toWaitingTurnState()
      }
    }
    else if (choice == 2) {
      gameState.toStandByState()
    }
  }

  /** Play a Card from the cpu Player or make the cpu player pass the Round.
   */
  def machineMove(cardChoice: Int): Unit = {
    if (!cpuPlayer.pass){
      cpuPlayer.playCard(cardChoice)
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
        cpuPlayer.playCard(machineCardChoice)
        theBoard.updateScores
      }
      machinePass()
      endingRound()
    }
  }

  /** Send to each Player the scores of the match.
   * 
   */
  def notifyPlayers(): Unit = {
    theBoard.assignPoints
    for (player <- thePlayers){
      player.updateGems(this, theBoard.FrontPoints(theBoard.round-1), theBoard.BackPoints(theBoard.round-1))
    }
  }

  /** A function used by the Players to updates their status.
   * 
   * @param player The Player who notifies.
   * @param defeated The defeated state of the Player.
   * @param draw The draw state of the match.
   */
  def updateLost(player: Player, defeated: Boolean, draw: Boolean): Unit ={
    if (draw){
      println(s"The round end in draw")
    }
    else{
      println(s"${player.getUsername} lost the round")
    }
    theBoard.clearBoard
    humanPlayer.pass = false
    cpuPlayer.pass = false
    if (defeated){
      println(s"${player.getUsername} has lost the match.")
      gameState.toAfterMatchState()
    }
    else{
      gameState.toBeginRoundState()
    }
  }

  /** Show scores and start rematch if is the case.
   * 
   */
  def postMatch(): Unit = {
    humanPlayer.pass = false
    cpuPlayer.pass = false
    var round3 = 0
    if (theBoard.round==3){
      println(s"${humanPlayer.getUsername} points: Round 1: ${theBoard.FrontPoints.head} | Round 2: ${theBoard.FrontPoints(1)} | Round 3: ${theBoard.FrontPoints(2)}")
      println(s"${cpuPlayer.getUsername} points: Round 1: ${theBoard.BackPoints.head} | Round 2: ${theBoard.BackPoints(1)} | Round 3: ${theBoard.BackPoints(2)}")
    }
    else{
      println(s"${humanPlayer.getUsername} points: Round 1: ${theBoard.FrontPoints.head} | Round 2: ${theBoard.FrontPoints(1)}")
      println(s"${cpuPlayer.getUsername} points: Round 1: ${theBoard.BackPoints.head} | Round 2: ${theBoard.BackPoints(1)}")
    }
    if (rematch){
      println("Starting rematch")
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
    theBoard.showBoard
  }
}
