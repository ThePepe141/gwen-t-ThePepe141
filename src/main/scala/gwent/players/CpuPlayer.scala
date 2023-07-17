package cl.uchile.dcc
package gwent.players
import gwent.cards.Card

import scala.collection.mutable.ListBuffer

/** A class that represents a Player controlled by the CPU.
 * 
 * @param deck The deck the CPU is going to use.
 */
class CpuPlayer (deck: ListBuffer[Card]) extends AbstractPlayer("CPU", deck) {
  
  //Equals -----------------------------------------------------

  /** A function that compares the types of two values.
   * 
   * @param that The other value to compare.
   *  @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CpuPlayer]

  /** A function that compares the structure of two objects.
   * 
   * @param that The object to compare.
   *  @return True if the two objects have the same structure.
   */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)){
      super.equals(that)
    }
    else{
      false
    }
  }
  //--------------------------------------------------------------------

  /** A function that choose the first Card of the hand.
   * 
   * @return The index 0 of the hand.
   */
  override def chooseCard: Int = 0
  

}
