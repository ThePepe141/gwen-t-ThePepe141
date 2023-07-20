package cl.uchile.dcc
package gwent.cards.effects
import gwent.cards.{UnitCard, WeatherCard}

class NullEffect extends Effect {

  override def effect(self: WeatherCard, target: UnitCard): Unit = {
    //Nothing
  }

}
