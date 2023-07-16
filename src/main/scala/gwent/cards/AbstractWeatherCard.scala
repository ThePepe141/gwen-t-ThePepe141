package cl.uchile.dcc
package gwent.cards
import gwent.board.BoardSection

/** A class that represents a Weather type Card.
 *
 * @param name The name of the Card.
 */
abstract class AbstractWeatherCard(val name: String) extends WeatherCard {

  /** The effect this Card has in the Board.
   */
  override def weatherEffect: Unit = {println("Aqui iria mi efecto, si tuviera uno!!")}

  /** A function that set the weather of the Board to the one of the card.
   * 
   * @param section The BoardSection where the card is placed.
   */
  override def playOnBoardSection(section: BoardSection): Unit = {
    section.putCardWR(this)
  }

  
}
 