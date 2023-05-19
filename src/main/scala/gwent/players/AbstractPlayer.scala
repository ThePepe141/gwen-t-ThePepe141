package cl.uchile.dcc
package gwent.players

import gwent.cards.Card

abstract class AbstractPlayer extends Player {
  
  val username: String = "Player1"
  var gems: Int = 2
  var deck: List[Card] = List()
  var hand: List[Card] = List()
  
  def getUsername: String = username
  def getGems: Int = gems
  def roundLost: Unit = {math.max(0, gems-1)}
  def isDefeated: Boolean = {gems==0}
  
  def barajar: Unit
  def robar: Unit

}
