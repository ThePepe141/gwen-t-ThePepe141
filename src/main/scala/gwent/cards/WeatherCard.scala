package cl.uchile.dcc
package gwent.cards

import gwent.cards.effects.Effect

/** A trait that represents a Card of type Weather.
 */
trait WeatherCard extends Card {

  /** The rows affected by the effect of the Card.
   * 
   */
  val rows: List[Int]

  /** The effect of the WeatherCard, NullEffect by default.
   * 
   */
  val effect: Effect
}
