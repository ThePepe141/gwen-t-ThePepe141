package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.cards.units.Geralt
import cl.uchile.dcc.gwent.cards.weathers.SunnyDay
import munit.FunSuite

class CardTest extends FunSuite {
  val name = "Geralt"
  val weather = "sunnyDay"
  var GeraltCard: Geralt = _
  var sunnyDay: SunnyDay = _

  override def beforeEach(context: BeforeEach): Unit = {
    GeraltCard = new Geralt()
    sunnyDay = new SunnyDay()
  }

  test("A UnitCard requires three parameters") {
    assertEquals(GeraltCard.getName, name)
    assertEquals(GeraltCard.getBasePower, 15)
  }
  test("At first the UnitCard's currentPower it's the same as it's basePower") {
    assertEquals(GeraltCard.basePower, GeraltCard.currentPower)
  }
  test("The currentPower cant be less than 0") {
    GeraltCard.currentPower = -100
    assertEquals(GeraltCard.currentPower, 0)
  }
}
