package cl.uchile.dcc
package gwent.players
import cl.uchile.dcc.gwent.cards.Card

import scala.collection.mutable.ListBuffer
import scala.util.Random

class HumanPlayer(override val username: String, var theDeck: ListBuffer[Card]) extends AbstractPlayer(username = username, deck = theDeck) {

}
