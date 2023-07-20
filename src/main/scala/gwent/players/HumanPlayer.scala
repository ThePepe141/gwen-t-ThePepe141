package cl.uchile.dcc
package gwent.players
import gwent.cards.Card

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

  /** A function that allows the Player to choose a Card (in hand) to play.
   *
   * @return The choice of the Player.
   */
  override def chooseCard: Int = {
    println("Please write the number of the Card you want to play")
    for (a <- hand.indices) {
      println(s"$a , ${hand(a)}")
    }
    val choice = readLine().toInt
    choice
  }
  
}
