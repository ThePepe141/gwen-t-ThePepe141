package cl.uchile.dcc
package gwent.players
import gwent.{Card, Player}
import scala.util.Random

class HumanPlayer (override val username: String, var deck: List[Card]) extends Player {
  override val boardSection: String = "Front"
  var hand: List[Card] = List()

  override def getUsername: String = username

  override def getGems: Int = gems

  override def isDefeated: Boolean = {
    gems == 0
  }
  override def roundLost: Unit = {
    gems -= 1
  }

}
