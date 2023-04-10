package cl.uchile.dcc
package gwent.cards

import munit.FunSuite

class CardTest extends FunSuite {
  val name = "Ciri"
  val weather = "sunnyDay"
  var CiriCard: UnitCard = _
  var sunnyDay: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    CiriCard = new UnitCard(name, 15, "Melee Combat")
    sunnyDay = new WeatherCard(weather)
  }

  test("A UnitCard requires three parameters") {
    assertEquals(CiriCard.name, name)
    assertEquals(CiriCard.basePower, 15)
    assertEquals(CiriCard.combatRow, "Melee Combat")
  }
  test("At first the UnitCard's currentPower it's the same as it's basePower") {
    assertEquals(CiriCard.basePower, CiriCard.currentPower)
  }
}
