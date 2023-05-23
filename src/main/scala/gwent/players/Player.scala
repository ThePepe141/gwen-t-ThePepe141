package cl.uchile.dcc
package gwent.players

import gwent.cards.Card
import scala.collection.mutable.ListBuffer

import cl.uchile.dcc.gwent.board.BoardSection

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
  protected var boardSection: Array[BoardSection]

  /** Getter of the username value.
   *
   * @return username.
   */
  def getUsername: String

  /** Getter of the gems variable.
   *
   * @return gems.
   */
  def getGems: Int

  /** Getter of deck variable.
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
  def shuffleDeck: Unit

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

}
