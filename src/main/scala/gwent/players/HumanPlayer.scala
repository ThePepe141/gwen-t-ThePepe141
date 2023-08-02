package cl.uchile.dcc
package gwent.players
import gwent.cards.Card

import gwent.GameController
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

/** A class that represents a Player controlled by an user.
 * 
 * @param username The name of the Player.
 * @param deck The deck the user is going to use.
 */
class HumanPlayer(username: String, deck: ListBuffer[Card]) extends AbstractPlayer(username, deck) {
  
  //Equals ------------------------------------------------------------------

  /** A function that compares the types of two values.
   * 
   * @param that The other value to compare.
   *  @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[HumanPlayer]

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
  //---------------------------------------------------------------

  override def updateGems(gameController: GameController, humanPoints: Int, cpuPoints: Int): Unit = {
    if (humanPoints<cpuPoints){
      this.roundLost
      gameController.updateLost(this, this.isDefeated, false)
    }
    else if (humanPoints==cpuPoints){
      this.roundLost
      gameController.updateLost(this, this.isDefeated, true)
    }
  }
  
}
