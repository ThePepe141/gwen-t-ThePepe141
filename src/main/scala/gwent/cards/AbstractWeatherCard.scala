package cl.uchile.dcc
package gwent.cards
abstract class AbstractWeatherCard(val name: String) extends WeatherCard {
  def getName: String = name
  
  /*La funcion hazzard es para la habilidad de clima especifica*/
  def hazzard: Unit = {println("Aqui iria mi efecto, si tuviera uno!!")}
  
}
 