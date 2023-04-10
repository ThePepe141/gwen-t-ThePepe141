package cl.uchile.dcc
package gwent.cards
import gwent.Card
class WeatherCard (val myName: String) extends Card {
  override val name: String = myName
  override val classification: String = "Weather"

  override def getName(): String = myName
}
