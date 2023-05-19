package cl.uchile.dcc
package gwent.players

import gwent.cards.Card

trait Player {
  val username: String
  var gems: Int
  var deck: List[Card]
  var hand: List[Card]

  def getUsername: String

  def getGems: Int
  
  def barajar: Unit
  
  def robar: Unit

  def roundLost: Unit
  
  def isDefeated: Boolean

}
