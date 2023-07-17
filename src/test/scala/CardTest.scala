package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.cards.units.{Geralt, RedanianArcher, ReinforcedTrebuchet, TemerianInfantry}
import cl.uchile.dcc.gwent.cards.weathers.SunnyDay
import munit.FunSuite

class CardTest extends FunSuite {
  val name = "Geralt of Rivia"
  val weather = "sunnyDay"
  var Geralt: Geralt = _
  var coolerGeralt: Geralt = _
  var sunnyDay: SunnyDay = _
  var otherSunnyDay: SunnyDay = _
  var soldier1: TemerianInfantry = _
  var soldier2: TemerianInfantry = _
  var archer1: RedanianArcher = _
  var archer2: RedanianArcher = _
  var engine1: ReinforcedTrebuchet = _
  var engine2: ReinforcedTrebuchet = _

  override def beforeEach(context: BeforeEach): Unit = {
    Geralt = new Geralt()
    coolerGeralt = new Geralt()
    sunnyDay = new SunnyDay()
    otherSunnyDay = new SunnyDay()
    soldier1 = new TemerianInfantry()
    soldier2 = new TemerianInfantry()
    archer1 = new RedanianArcher()
    archer2 = new RedanianArcher()
    engine1 = new ReinforcedTrebuchet()
    engine2 = new ReinforcedTrebuchet()
  }

  test("Testing equals methods"){
    //Test for equals
    assert(Geralt.equals(coolerGeralt))
    assert(sunnyDay.equals(otherSunnyDay))
    assert(soldier1.equals(soldier2))
    assert(archer1.equals(archer2))
    assert(engine1.equals(engine2))
    Geralt.currentPower = 5
    assert(!Geralt.equals(coolerGeralt))

  }
  test("A UnitCard has a name and a power level") {
    //Test for getName and getBasePower
    assertEquals(Geralt.getName, name)
    assertEquals(Geralt.getBasePower, 15)
  }

  test("A UnitCard power can change, but its base power remains the same") {
    //Test for currentPower and currentPower=
    Geralt.currentPower = 4
    assertEquals(Geralt.currentPower, 4)
    assertEquals(Geralt.getBasePower, 15)
  }

  test("A UnitCard´s power cannot be lower than 0") {
    Geralt.currentPower = -1000
    assert(Geralt.currentPower>=0)
  }

  test("You can reset the power of a UnitCard") {
    //Test for  resetPower
    Geralt.currentPower = 4100000
    Geralt.resetPower
    assertEquals(Geralt.currentPower, Geralt.getBasePower)
  }

  test("UnitCard ability test") {
    //Test for ability
    Geralt.ability
  }

  test("WeatherCard ability test") {
    //Test for weatherEffect
    sunnyDay.weatherEffect
  }

}
