package cl.uchile.dcc
package gwent.players
import cl.uchile.dcc.gwent.cards.Card

class CpuPlayer (var theDeck: List[Card]) extends AbstractPlayer(username = "GPU Player", deck = theDeck) {
  

}
