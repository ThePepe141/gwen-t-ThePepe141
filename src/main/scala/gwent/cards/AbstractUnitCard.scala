package cl.uchile.dcc
package gwent.cards

abstract class AbstractUnitCard(override val name: String, var _power: Int) extends UnitCard {
  val basePower: Int = _power

  def getName: String = name
  def getBasePower: Int = basePower

  def currentPower: Int = _power

  def currentPower_=(newPower: Int): Unit = {
    _power = math.max(0, newPower)
  }

  def resetPower: Unit = { _power = getBasePower }
  
  /*Funcion ability es para las cartas con habilidades especiales*/
  def ability: Unit

}
