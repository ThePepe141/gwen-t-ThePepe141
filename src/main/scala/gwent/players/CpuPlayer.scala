package cl.uchile.dcc
package gwent.players
import gwent.cards.Card

import scala.collection.mutable.ListBuffer

/** A class that represents a Player controlled by the CPU.
 * 
 * @param theDeck The deck the CPU is going to use.
 */
class CpuPlayer (var theDeck: ListBuffer[Card]) extends AbstractPlayer(username = "CPU", deck = theDeck) {
  

}
