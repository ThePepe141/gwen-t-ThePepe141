package cl.uchile.dcc
package gwent.players
import gwent.cards.Card

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** A class that represents a Player controlled by an user.
 * 
 * @param username The name of the Player.
 * @param deck The deck the user is going to use.
 */
class HumanPlayer(username: String, deck: ListBuffer[Card]) extends AbstractPlayer(username, deck) {

}
