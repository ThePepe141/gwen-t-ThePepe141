package cl.uchile.dcc
package gwent.players

import gwent.cards.Card
import gwent.board.BoardSection

import scala.collection.mutable.ListBuffer
import scala.util.Random


/** A class that represents a Player.
 * 
 * @param username The name of the Player.
 * @param deck The deck of Cards of the Player
 */
abstract class AbstractPlayer(override protected val username: String, protected var deck: ListBuffer[Card] = ListBuffer[Card]()) extends Player {

  /** The number of gems a Player has.
   * 
   * A Player starts with 2.
   */
  protected var gems: Int = 2

  /** The list of Cards the Player can play.
   * 
   *  It begins empty until the start of the first round of the match.
   */
  protected var hand: ListBuffer[Card] = new ListBuffer[Card]()

  /** The BoardSection assign to the Player for the match.
   * 
   *  It fills at the start of the match.
   */
  protected var boardSection: BoardSection = _

  /** Indicates if the player is in a Match
   */
  protected var inMatch: Boolean = false

  /** Getter of username param.
   * 
   *  @return username.
   */
  override def getUsername: String = username

  /** Getter of gems param.
   * 
   *  @return gems.
   */
  override def getGems: Int = gems

  /** Getter of hand param.
   * 
   *  @return hand.
   */
  override def getHand: ListBuffer[Card] = hand

  /** Getter of deck param.
   * 
   * @return deck.
   */
  override def getDeck: ListBuffer[Card] = deck

  /** Calculates the size of the deck.
   * 
   *  @return number of Cards in deck.
   */
  override def deckSize: Int = deck.length

  /** Reduce gems variable by 1.
   * 
   */
  override def roundLost: Unit = {gems = {math.max(0, gems-1)}}

  /** Boolean, assert if a Player has lost the match.
   * 
   *  @return True or False.
   */
  override def isDefeated: Boolean = {gems==0}

  /** Shuffle the Player´s deck.
   */
  override def deckShuffle: Unit = {
    assert(deck.nonEmpty)
    deck = Random.shuffle(deck)
  }

  /** Pick a the first Card of the deck.
   */
  override def drawCard: Unit = {
    assert(deck.nonEmpty)
    val theCard: Card = deck.head
    deck = deck.tail
    hand += theCard
  }

  /** Assign a BoardSection object to the Player for the match.
   * 
   * @param newSection An instance of class BoardSection.
   */
  override def assignBoardSection(newSection: BoardSection): Unit = {
    boardSection = newSection
  }

  /** Add a Card to the deck.
   *
   * @param card The Card to add.
   */
  override def addToDeck(card: Card): Unit = {
    if (!inMatch){
      deck.append(card)
    }
  }

  /** Getter of the boardSection param.
   *
   * @return boardSection.
   */
  def getBoardSection: BoardSection = boardSection
  
  

}
