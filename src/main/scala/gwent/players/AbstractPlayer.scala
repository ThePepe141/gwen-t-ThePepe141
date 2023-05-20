package cl.uchile.dcc
package gwent.players

import gwent.cards.Card
import gwent.board.BoardSection

import scala.collection.mutable.ListBuffer
import scala.util.Random

abstract class AbstractPlayer(override protected val username: String, protected var deck: ListBuffer[Card]) extends Player {
  
  protected var gems: Int = 2
  protected var hand: ListBuffer[Card] = new ListBuffer[Card]()
  var boardSection: Array[BoardSection] = Array[BoardSection]()
  
  override def getUsername(): String = username
  override def getGems(): Int = gems
  override def deckSize(): Int = deck.length
  override def roundLost(): Unit = {gems = {math.max(0, gems-1)}}
  override def isDefeated(): Boolean = {gems==0}
  override def shuffleDeck(): Unit = {
    assert(deck.nonEmpty)
    deck = Random.shuffle(deck)
  }
  override def drawCard(): Unit = {
    assert(deck.nonEmpty)
    val theCard: Card = deck.head
    deck = deck.tail
    hand += theCard
  }
  override def assignBoardSection(newSection: BoardSection): Unit = {
    boardSection = Array[BoardSection](newSection)
  }
  
  

}
