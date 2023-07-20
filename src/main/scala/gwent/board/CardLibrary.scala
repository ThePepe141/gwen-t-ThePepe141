package cl.uchile.dcc
package gwent.board

import Array.*
import gwent.cards.{Card, CloseCombatUnit, RangedCombatUnit, SiegeCombatUnit, WeatherCard}

import cl.uchile.dcc.gwent.cards.units.{BlueStripesCommando, Catapult, CrinfridReaversHunter, Dandelion, Geralt, KaedweniSiegeExpert, RedanianArcher, ReinforcedTrebuchet, TemerianInfantry}
import cl.uchile.dcc.gwent.cards.weathers.{BitingFrost, ImpenetrableFog, SunnyDay, TorrentialRain}

import scala.collection.mutable.ListBuffer

class CardLibrary{

  var closeCombatCards: ListBuffer[CloseCombatUnit] = ListBuffer[CloseCombatUnit]()
  
  closeCombatCards :+ new BlueStripesCommando
  closeCombatCards :+ new TemerianInfantry
  closeCombatCards :+ new Geralt
  closeCombatCards :+ new Dandelion
  
  var rangedCombatCards: ListBuffer[RangedCombatUnit] = ListBuffer[RangedCombatUnit]()
  
  rangedCombatCards :+ new CrinfridReaversHunter
  rangedCombatCards :+ new RedanianArcher
  
  var siegeCombatCards: ListBuffer[SiegeCombatUnit] = ListBuffer[SiegeCombatUnit]()
  
  siegeCombatCards :+ new Catapult
  siegeCombatCards :+ new ReinforcedTrebuchet
  siegeCombatCards :+ new KaedweniSiegeExpert
  
  var weatherCards: ListBuffer[WeatherCard] = ListBuffer[WeatherCard]()
  
  weatherCards :+ new SunnyDay
  weatherCards :+ new BitingFrost
  weatherCards :+ new ImpenetrableFog
  weatherCards :+ new TorrentialRain
  
  def showLibrary(): Unit = {
    println("Set 1: Close Combat Cards")
    for (a <- closeCombatCards.indices) {
      println(s"$a, ${closeCombatCards(a).toString}")
    }
    println("Set 2: Ranged Combat Cards")
    for (b <- rangedCombatCards.indices) {
      println(s"$b, ${rangedCombatCards(b).toString}")
    }
    println("Set 3: Siege Combat Cards")
    for (c <- siegeCombatCards.indices) {
      println(s"$c, ${siegeCombatCards(c).toString}")
    }
    println("Set 4: Weather Cards")
    for (d <- weatherCards.indices) {
      println(s"$d, ${weatherCards(d).toString}")
    }
  }
  

}
