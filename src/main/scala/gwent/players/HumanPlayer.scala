package cl.uchile.dcc
package gwent.players
import cl.uchile.dcc.gwent.cards.Card
import scala.util.Random

class HumanPlayer(override val username: String, var theDeck: List[Card]) extends AbstractPlayer(username = username, deck = theDeck) {

}
