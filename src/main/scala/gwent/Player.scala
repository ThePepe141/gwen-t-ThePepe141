package cl.uchile.dcc
package gwent

trait Player {
  val username: String
  val boardSection: String
  var gems: Int
  /**var deck: Array[Card]
  var hand: Array[Card]*/

  def getUsername(): String

}
