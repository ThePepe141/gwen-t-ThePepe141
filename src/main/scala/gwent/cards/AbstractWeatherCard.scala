package cl.uchile.dcc
package gwent.cards
import gwent.cards.WeatherCard

/** A class that represents a Weather type Card.
 *
 * @param name The name of the Card.
 */
abstract class AbstractWeatherCard(val name: String) extends WeatherCard {

  /** The effect this Card has in the Board.
   */
  override def weatherEffect: Unit = {println("Aqui iria mi efecto, si tuviera uno!!")}
  
}
 