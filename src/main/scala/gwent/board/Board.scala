package cl.uchile.dcc
package gwent.board

import gwent.players.Player
import gwent.players.{CpuPlayer, HumanPlayer}

import gwent.cards.WeatherCard
import gwent.exceptions.CardLimitException

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** A class that represents the Board of a match. It requires 2 Players.
 * 
 * @param player1 The HumanPlayer of the match.
 * @param player2 The CpuPlayer of the match.
 */
class Board(val player1: HumanPlayer, val player2: CpuPlayer) {

  /** The round currently at play.
   */
  var round: Int = 0

  /** BoardSection for HumanPlayer.
   */
  var Front: BoardSection = new BoardSection(this)

  /**BoardSection for CpuPlayer.
   */
  var Back: BoardSection = new BoardSection(this)

  /** The weather currently being played on the Board.
   */
  private var Weather: ListBuffer[WeatherCard] = ListBuffer[WeatherCard]()

  /** A list with the Human player end points of each round.
   */
  var FrontPoints: ListBuffer[Int] = ListBuffer[Int]()

  /** A List with the CPU player end points od each round.
   */
  var BackPoints: ListBuffer[Int] = ListBuffer[Int]()
  
  var players: ListBuffer[Player] = ListBuffer[Player](player1, player2)
  
  var coin: Int = _

  /** Getter of Weather.
   *
   * @return the weather on the match.
   */
  def getWeather: ListBuffer[WeatherCard] = Weather

  /** A function that assign BoardSections to the players.
   */
  def assignSections: Unit = {
    player1.assignBoardSection(Front)
    player2.assignBoardSection(Back)
  }

  /** A function that assign the scores of each round to FrontPoints and BackPoints.
   */
  def assignPoints: Unit = {
    FrontPoints = FrontPoints :+ Front.getTotalPower
    BackPoints = BackPoints :+ Back.getTotalPower
  }

  /** It gives to each Player a specific number of Cards.
   * 
   * The number depends of the round. Round 1 -> 10 Cards, Other round -> 3 Cards
   */
  def handOutCards(): Unit = {
    if (round==1){
      for (_ <- 1 to 10) {
        player1.drawCard
        player2.drawCard
      }
    }
    else {
      for (_ <- 1 to 3) {
        player1.drawCard
        player2.drawCard
      }
    }
  }

  /** Initiate a match.
   * 
   * Verify limit number of Cards in each deck
   * and shuffle the decks.
   */
  def startMatch: Unit = {
    if (player1.deckSize<25){
      throw new CardLimitException(s"${player1.getUsername} don´t have enough cards, current number: ${player1.deckSize}, required: 25")
    }
    else if (player2.deckSize<25){
      throw new CardLimitException(s"${player2.getUsername} don´t have enough cards, current number: ${player2.deckSize}, required: 25")
    }
    else{
      player1.startMatch
      player2.startMatch

      player1.deckShuffle
      player2.deckShuffle
      coin = Random.between(0,2)
    }
  }

  /** Start a round
   * 
   * Hand out Cards to each Player.
   */
  def startRound: Unit = {
    round += 1
    handOutCards()
  }

  /** A function that updates and applies the Weather on the Board.
   *
   * @param weatherCard The weather to apply to the board.
   */
  def assignWeather(weatherCard: WeatherCard): Unit = {
    Weather = ListBuffer[WeatherCard](weatherCard)
    for (row <- weatherCard.rows) {
      if (row == 1) {
        Front.notifyObserversCCR(weatherCard, weatherCard.effect)
        Back.notifyObserversCCR(weatherCard, weatherCard.effect)
      }
      else if (row == 2) {
        Front.notifyObserversRCR(weatherCard, weatherCard.effect)
        Back.notifyObserversRCR(weatherCard, weatherCard.effect)
      }
      else if (row == 3) {
        Front.notifyObserversSCR(weatherCard, weatherCard.effect)
        Back.notifyObserversSCR(weatherCard, weatherCard.effect)
      }
    }
    Front.updateTotalPower
    Back.updateTotalPower
    println(s"Name: ${weatherCard.getName} has been summoned")
  }

  /** A function that clears all rows on the Board.
   */
  def clearBoard: Unit = {
    Front.clearBoardSection
    Back.clearBoardSection
    Weather = ListBuffer[WeatherCard]()
  }

  /** A function that updates the scores of each player.
   */
  def updateScores: Unit = {
    Front.updateTotalPower
    Back.updateTotalPower
  }

  /** Print all cards in all rows, except graveyard and weather.
   */
  def showBoard: Unit = {
    println("The Opponent side")
    println("Siege Combat Row")
    Back.showSiegeCombatRow()
    println("Ranged Combat Row")
    Back.showRangedCombatRow()
    println("Close Combat Row")
    Back.showCloseCombatRow()
    println("Your side")
    println("Close Combat Row")
    Front.showCloseCombatRow()
    println("Ranged Combat Row")
    Front.showRangedCombatRow()
    println("Siege Combat Row")
    Front.showSiegeCombatRow()
  }

}
