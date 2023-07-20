package cl.uchile.dcc
package gwent.cards.effects

import gwent.cards.{UnitCard, WeatherCard}

/** A trait that represents the effects of the WeatherCards.
 * 
 */
trait Effect {

  /** Applies the effect to a Card.
   * 
   * @param self The Card of the Effect.
   * @param target The Card to apply the Effect.
   */
  def effect(self: WeatherCard, target: UnitCard): Unit

}
