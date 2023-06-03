package cl.uchile.dcc
package gwent.players
import gwent.cards.Card

import scala.collection.mutable.ListBuffer

/** A class that represents a Player controlled by the CPU.
 * 
 * @param deck The deck the CPU is going to use.
 */
class CpuPlayer (deck: ListBuffer[Card]) extends AbstractPlayer("CPU", deck) {

  /** A function that choose the first Card of the hand.
   * 
   * @return The index 0 of the hand.
   */
  override def chooseCard: Int = 0
  

}
