package cl.uchile.dcc
package gwent.cards.weathers

import gwent.cards.AbstractWeatherCard

class SunnyDay extends AbstractWeatherCard(name = "Sunny Day"){
  
  
  override def weatherEffect: Unit = println("It´s sunny!")
}
