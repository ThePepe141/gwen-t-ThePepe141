package cl.uchile.dcc
package gwent.players

import gwent.cards.Card

trait Player {
  protected val username: String
  protected var gems: Int
  protected var deck: List[Card]
  protected var hand: List[Card]

  def getUsername: String

  def getGems: Int
  
  def shuffleDeck: Unit
  
  def pickCard: Card

  def roundLost: Unit
  
  def isDefeated: Boolean

}
