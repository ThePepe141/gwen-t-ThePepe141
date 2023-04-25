package cl.uchile.dcc
package gwent.cards
import gwent.Card
abstract class WeatherCard (override val name: String) extends Card {
  override def getName: String = name
  
  /*La funcion hazzard es para la habilidad de clima especifica*/
  def hazzard(): Unit
  
}
