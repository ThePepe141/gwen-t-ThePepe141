package cl.uchile.dcc
package gwent.players

import gwent.cards.Card

import scala.collection.mutable.ListBuffer
import gwent.board.{BoardSection}
import gwent.GameController

/** A trait that represents a Player.
 */
trait Player {

  /** The name of the Player.
   */
  protected val username: String

  /** The number of gems the Player has.
   */
  protected var gems: Int

  /** The deck the Player has.
   */
  protected var deck: ListBuffer[Card]

  /** The hand the Player has.
   */
  protected var hand: ListBuffer[Card]

  /** The section of the Board a Player occupied.
   */
  protected var boardSection: BoardSection

  /** Getter of the username param.
   *
   * @return username.
   */
  def getUsername: String

  /** Getter of the gems param.
   *
   * @return gems.
   */
  def getGems: Int

  /** Getter of the hand param.
   *
   * @return hand.
   */
  def getHand: ListBuffer[Card]

  /** Getter of deck param.
   * 
   * @return deck.
   */
  def getDeck: ListBuffer[Card]

  /** Calculates the number of Cards in the deck.
   *
   * @return number of Cards in deck.
   */
  def deckSize: Int

  /** Shuffle the deck.
   */
  def deckShuffle: Unit

  /** Pick the first Card of the deck.
   */
  def drawCard: Unit

  /** Reduce the number of gems by 1.
   */
  def roundLost: Unit

  /** It tells if a Player has lost the match.
   *
   * @return True or False .
   */
  def isDefeated: Boolean

  /** Assign a BoardSection object to the Player.
   *
   * @param newSection An instance of class BoardSection.
   */
  def assignBoardSection(newSection: BoardSection): Unit

  /** Add a Card to the deck.
   * 
   * @param card The Card to add.
   */
  def addToDeck(card: Card): Unit

  /** Update the gems of the player with the points send by the board.
   * Sends a message to the gameController in case of defeat (either the round or the match).
   * 
   * @param gameController The GameController associate with the match.
   * @param humanPoitns The points of the Human Player in the round.
   * @param cpuPoints The points of the Cpu Player in the round.
   */
  def updateGems(gameController: GameController, humanPoints: Int, cpuPoints: Int): Unit

}
