package cl.uchile.dcc
package gwent.board

import gwent.players.Player
import gwent.players.{CpuPlayer, HumanPlayer}

import cl.uchile.dcc.gwent.cards.WeatherCard

import scala.collection.mutable.ListBuffer

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

  /** It gives to each Player a specific number of Cards.
   * 
   * The number depends of the round. Round 1 -> 10 Cards, Other round -> 3 Cards
   */
  def handOutCards(): Unit = {
    if (round==1){
      for (a <- 1 to 10) {
        player1.drawCard
        player2.drawCard
      }
    }
    else {
      for (a <- 1 to 3) {
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
    assert(player1.deckSize >= 25)
    assert(player2.deckSize >= 25)
    
    player1.startMatch
    player2.startMatch

    player1.deckShuffle
    player2.deckShuffle
  }

  /** Start a round
   * 
   * Hand out Cards to each Player.
   */
  def startRound: Unit = {
    round += 1
    handOutCards()
  }

  /** A function that updates the Wather on the Board.
   *
   * @param weatherCard
   */
  def assignWeather(weatherCard: WeatherCard): Unit = {
    Weather = Weather :+ weatherCard
  }

}
