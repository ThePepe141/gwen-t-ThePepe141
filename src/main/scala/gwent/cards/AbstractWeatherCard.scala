package cl.uchile.dcc
package gwent.cards
abstract class AbstractWeatherCard(override val name: String) extends Card {
  override def getName: String = name
  
  /*La funcion hazzard es para la habilidad de clima especifica*/
  def hazzard(): Unit
  
}
