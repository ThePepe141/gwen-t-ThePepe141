package cl.uchile.dcc
package gwent.players

import gwent.cards.Card
import scala.util.Random

abstract class AbstractPlayer(override protected val username: String, protected var deck: List[Card]) extends Player {
  
  protected var gems: Int = 2
  protected var hand: List[Card] = List()
  
  def getUsername: String = username
  def getGems: Int = gems
  def roundLost: Unit = {math.max(0, gems-1)}
  def isDefeated: Boolean = {gems==0}
  
  def shuffleDeck: Unit = {
    assert(deck.nonEmpty)
    deck = Random.shuffle(deck)
  }
  def pickCard: Card = {
    assert(deck.nonEmpty)
    val theCard: Card = deck.head
    deck = deck.tail
    theCard
  }
  
  

}
