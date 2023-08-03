package cl.uchile.dcc
package gwent.players

import gwent.cards.Card
import gwent.GameController

import scala.collection.mutable.ListBuffer

/** A class that represents a Player controlled by the CPU.
 * 
 * @param deck The deck the CPU is going to use.
 */
class CpuPlayer (deck: ListBuffer[Card]) extends AbstractPlayer("CPU", deck) {
  
  //Equals, hashCode y toString  -----------------------------------------------------

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

  override def hashCode(): Int = {
    val primo = 31
    var total = 1
    total = primo * total + classOf[CpuPlayer].##
    total = primo * total + username.##
    total
  }

  override def toString: String = s"CpuPlayer(username=$getUsername, gems=$getGems)"
  //--------------------------------------------------------------------

  override def updateGems(gameController: GameController, humanPoints: Int, cpuPoints: Int): Unit = {
    if (humanPoints>cpuPoints){
      this.roundLost
      gameController.updateLost(this, this.isDefeated, false)
    }
    else if (humanPoints == cpuPoints) {
      this.roundLost
      gameController.updateLost(this, this.isDefeated, true)
    }
  }
  

}
