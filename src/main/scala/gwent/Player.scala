package cl.uchile.dcc
package gwent

trait Player {
  val username: String
  val boardSection: String
  var gems: Int = 2
  var deck: List[Card]
  var hand: List[Card]

  def getUsername: String
  def getGems: Int

  def isDefeated: Boolean
  def roundLost: Unit
  
}
