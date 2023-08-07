package cl.uchile.dcc
package gwent.cards.effects
import gwent.cards.{UnitCard, WeatherCard}

/** A class that represents the PowerToOne Effect.
 * 
 * Set the power of a Card to 1.
 * 
 */
class PowerToOne extends Effect {

  /** Applies the effect to a Card.
   * 
   * @param self The Card of the Effect.
   * @param target The Card to apply the Effect.
   */
  override def apply(self: WeatherCard, target: UnitCard): Unit = {
    target.setCurrentPower(1)
  }

}
