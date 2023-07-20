package cl.uchile.dcc
package gwent.cards.effects
import gwent.cards.{UnitCard, WeatherCard}

/** A class that represents the PowerToOne Effect.
 * 
 * Set the power of a Card to 1.
 * 
 */
class PowerToOne extends Effect {

  override def effect(self: WeatherCard, target: UnitCard): Unit = {
    target.setCurrentPower(1)
  }

}
