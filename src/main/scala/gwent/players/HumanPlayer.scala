package cl.uchile.dcc
package gwent.players
import gwent.{Card, Player}

class HumanPlayer (val myName: String) extends Player {
  override val username: String = myName
  override val boardSection: String = "Front"
  var gems: Int = 2

  override def getUsername(): String = username
}
