package cl.uchile.dcc
package gwent.players
import cl.uchile.dcc.gwent.cards.Card

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** A class that represents a Player controlled by an user.
 * 
 * @param username The name of the Player.
 * @param theDeck The deck the user is going to use.
 */
class HumanPlayer(override val username: String, var theDeck: ListBuffer[Card]) extends AbstractPlayer(username = username, deck = theDeck) {

}
