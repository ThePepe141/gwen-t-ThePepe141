package cl.uchile.dcc
package gwent.players
import cl.uchile.dcc.gwent.cards.Card

class CpuPlayer (override var deck: List[Card]) extends AbstractPlayer {

  override val username: String = "GPU Player"

}
