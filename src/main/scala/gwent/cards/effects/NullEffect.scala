package cl.uchile.dcc
package gwent.cards.effects
import gwent.cards.{UnitCard, WeatherCard}

/** A class that represents the Null Effect for a WeatherCard.
 * 
 */
class NullEffect extends Effect {

  /** Applies the effect to a Card.
   * 
   * @param self The Card of the Effect.
   * @param target The Card to apply the Effect.
   */
  override def effect(self: WeatherCard, target: UnitCard): Unit = {
    //Nothing
  }

}
