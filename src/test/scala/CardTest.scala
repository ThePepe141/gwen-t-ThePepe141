package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.cards.units.Geralt
import cl.uchile.dcc.gwent.cards.weathers.SunnyDay
import munit.FunSuite

class CardTest extends FunSuite {
  val name = "Geralt of Rivia"
  val weather = "sunnyDay"
  var Geralt: Geralt = _
  var sunnyDay: SunnyDay = _

  override def beforeEach(context: BeforeEach): Unit = {
    Geralt = new Geralt()
    sunnyDay = new SunnyDay()
  }

  test("A UnitCard has a name and a power level") {
    assertEquals(Geralt.getName, name)
    assertEquals(Geralt.getBasePower, 15)
  }

  test("A UnitCard power can change, but its base power remains the same") {
    Geralt.currentPower = 4
    assertEquals(Geralt.currentPower, 4)
    assertEquals(Geralt.getBasePower, 15)
  }

  test("A UnitCard´s power cannot be lower than 0") {
    Geralt.currentPower = -1000
    assert(Geralt.currentPower>=0)
  }

  test("You can reset the power of a UnitCard") {
    Geralt.currentPower = 4100000
    Geralt.resetPower
    assertEquals(Geralt.currentPower, Geralt.getBasePower)
  }

  test("UnitCard ability test") {
    Geralt.ability
  }

  test("WeatherCard ability test") {
    sunnyDay.weatherEffect
  }

}
