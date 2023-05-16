package cl.uchile.dcc
package gwent.players
import gwent.Player
import cl.uchile.dcc.gwent.cards.Card

class CpuPlayer (var deck: List[Card]) extends Player{
  override val username: String = "CPU"
  override val boardSection: String = "Back"
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
