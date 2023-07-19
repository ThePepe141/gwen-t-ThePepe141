package cl.uchile.dcc
package gwent.cards.effects

import gwent.cards.{UnitCard, WeatherCard}

trait Effect {

  def effect(self: WeatherCard, target: UnitCard): Unit

}
