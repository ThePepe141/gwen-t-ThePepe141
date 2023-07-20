package cl.uchile.dcc
package gwent.cards.effects
import gwent.cards.{UnitCard, WeatherCard}

class NullEffect(rows: List[Int] ) extends Effect(rows) {

  override def effect(self: WeatherCard, target: UnitCard): Unit = {
    //Nothing
  }

}
