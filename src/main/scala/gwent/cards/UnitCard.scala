package cl.uchile.dcc
package gwent.cards

import gwent.Card

abstract class UnitCard(override val name: String, protected var _power: Int) extends Card {
  val basePower: Int = _power
  val row: String

  override def getName: String = name
  def getBasePower: Int = basePower
  def getRow: String

  def currentPower: Int = _power

  def currentPower_=(newPower: Int): Unit = {
    _power = math.max(0, newPower)
  }
  /*Funcion ability es para las cartas con habilidades especiales*/
  def ability: Unit

}
