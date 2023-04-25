package cl.uchile.dcc
package gwent.cards

import munit.FunSuite

class CardTest extends FunSuite {
  val name = "Geralt"
  val weather = "sunnyDay"
  var GeraltCard: Witcher = _
  var sunnyDay: SunnyDay = _

  override def beforeEach(context: BeforeEach): Unit = {
    GeraltCard = new Witcher(name, 15)
    sunnyDay = new SunnyDay(weather)
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
