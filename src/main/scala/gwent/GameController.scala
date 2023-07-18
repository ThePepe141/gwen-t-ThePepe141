package cl.uchile.dcc
package gwent

import gwent.board.{Board, CardLibrary}

import cl.uchile.dcc.gwent.cards.Card

import scala.io.StdIn.readLine
import cl.uchile.dcc.gwent.players.{CpuPlayer, HumanPlayer}
import cl.uchile.dcc.gwent.states.{BeforeMatchState, GameState}
import scala.util.Random

import scala.collection.mutable.ListBuffer

class GameController {

  /** The current state of the game
   */
  var gameState: GameState = new BeforeMatchState(this)
  
  var humanPlayer: HumanPlayer = _
  var cpuPlayer: CpuPlayer = _
  var board: Board = _

  gameState.action
  startMatch

  /** A function that initiates the match.
   *
   * The player choose build both decks and start the match.
   */
  def buildDecks: Unit = {
    println("Hello Human player, please choose your name")
    val name = readLine()
    humanPlayer = new HumanPlayer(name, ListBuffer[Card]())
    cpuPlayer = new CpuPlayer(ListBuffer[Card]())
    println("Thank you")
    println("Now choose your deck")
    val library = new CardLibrary()
    //Show card options
    println("Set 1: Close Combat Cards")
    for (a <- library.closeCombatCards.indices){
      println(s"$a, ${library.closeCombatCards(a).toString}")
    }
    println("Set 2: Ranged Combat Cards")
    for (b <- library.rangedCombatCards.indices){
      println(s"$b, ${library.rangedCombatCards(b).toString}")
    }
    println("Set 3: Siege Combat Cards")
    for (c <- library.siegeCombatCards.indices){
      println(s"$c, ${library.siegeCombatCards(c).toString}")
    }
    println("Set 4: Weather Cards")
    for (d <- library.weatherCards.indices){
      println(s"$d, ${library.weatherCards(d).toString}")
    }
    println("Write the number of the set you want to pick for or -1 to finish")
    //Choose cards for human deck
    var a = readLine().toInt
    while (a != -1 || humanPlayer.deckSize<25){
      if (a== -1){
        println("Your deck doesn´t have the minimum of cards")
      }
      else if (a!=1 && a!=2 && a!=3 && a!=4){
        println("Invalid set number")
      }
      else{
        println("Which card do you want (write the index)")
        var b = readLine().toInt
        if (a == 1){
          humanPlayer.addToDeck(library.closeCombatCards(b))
        }
        else if (a == 2){
          humanPlayer.addToDeck(library.rangedCombatCards(b))
        }
        else if (a == 3){
          humanPlayer.addToDeck(library.siegeCombatCards(b))
        }
        else if (a == 4){
          humanPlayer.addToDeck(library.weatherCards(b))
        }
        println("Your current deck")
        showDeck
      }
      println("Write the number of the set you want to pick for or -1 to finish")
      a = readLine().toInt
    }
    println("Your deck has been filled")
    showDeck
    println("Please choose your opponent´s deck")
    println("Write the number of the set you want to pick for or -1 to finish")
    //Choose cards for cpu deck
    var x = readLine().toInt
    while (x != -1 || cpuPlayer.deckSize < 25) {
      if (x == -1) {
        println("Your deck doesn´t have the minimum of cards")
      }
      else if (x != 1 && x != 2 && x != 3 && x != 4) {
        println("Invalid set number")
      }
      else {
        println("Which card do you want (write the index)")
        var b = readLine().toInt
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
    board = new Board(humanPlayer, cpuPlayer)
  }

  def startMatch: Unit = {
    println("The Match has started!")
    val coin = Random.nextInt(2)
    if (coin == 0) {
      gameState.toInTurnState
    }
    else {
      gameState.toWaitingTurnState
    }
  }

  def startRound: Unit = {
    board.startRound
    println("You start first")
    showHand
    gameState.action
  }

  /** The player choose between play a card or pass
   */
  def makeChoice: Unit = {
    println("Choose 1 to play a card choose 2 to pass")
    val choice = readLine().toInt
    if (choice==1){
      humanPlayer.playCard
      board.Front.updateTotalPower
      board.Back.updateTotalPower
      if (humanPlayer.getHand.isEmpty){
        gameState.toStandByState
      }
      else{
        gameState.toWaitingTurnState
      }
    }
    else{
      gameState.toStandByState
    }
  }

  def opponentMove: Unit = {
    while(board.Back.getTotalPower<board.Front.getTotalPower || cpuPlayer.getHand.isEmpty){
      cpuPlayer.playCard
    }
    if (cpuPlayer.getHand.isEmpty){
      //something
    }
    else{
      //something
    }
  }


  //Show functions -------------------------------------------------------------
  /** Shows the player´s hand.
   */
  def showHand: Unit = {
    for (card <- humanPlayer.getHand) {
      println(card.toString)
    }
  }

  /** Shows the player´s deck.
   */
  def showDeck: Unit = {
    for (card <- humanPlayer.getDeck){
      println(card.toString)
    }
  }

  /** Shows the CloseCombatRow.
   *
   * @param yourSide True to show your row, false to show the opponents.
   */
  def showCloseCombatRow(yourSide: Boolean): Unit = {
    if (yourSide){
      val row = board.Front.getCloseCombatRow(true)
    }
    else{
      val row = board.Back.getCloseCombatRow(true)
    }
  }

  /** Shows the RangedCombatRow.
   *
   * @param yourSide True to show your row, false to show the opponents.
   */
  def showRangedCombatRow(yourSide: Boolean): Unit = {
    if (yourSide){
      val row = board.Front.getRangedCombatRow(true)
    }
    else{
      val row = board.Back.getRangedCombatRow(true)
    }
  }

  /** Shows the SiegeCombatRow.
   *
   * @param yourSide True to show your row, false to show the opponents.
   */
  def showSiegeCombatRow(yourSide: Boolean): Unit = {
    if (yourSide){
      val row = board.Front.getSiegeCombatRow(true)
    }
    else{
      val row = board.Back.getSiegeCombatRow(true)
    }
  }

  /** Show the weathers on the board.
   */
  def showWeathers: Unit = {
    val row = board.getWeather(true)
  }
  //-------------------------------------------------------------------------

}
