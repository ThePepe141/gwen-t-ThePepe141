package cl.uchile.dcc
package gwent.cards

class SunnyDay extends WeatherCard{
  override val name: String = "Sunny Day"
  
  override def hazzard(): Unit = println("It´s sunny!")
}
