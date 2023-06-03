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
