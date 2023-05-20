package cl.uchile.dcc
package gwent.players
import cl.uchile.dcc.gwent.cards.Card

import scala.collection.mutable.ListBuffer

class CpuPlayer (var theDeck: ListBuffer[Card]) extends AbstractPlayer(username = "GPU Player", deck = theDeck) {
  

}
