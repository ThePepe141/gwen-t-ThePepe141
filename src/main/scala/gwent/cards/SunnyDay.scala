package cl.uchile.dcc
package gwent.cards

class SunnyDay extends AbstractWeatherCard(name = "Sunny Day"){
  
  
  override def hazzard(): Unit = println("It´s sunny!")
}
