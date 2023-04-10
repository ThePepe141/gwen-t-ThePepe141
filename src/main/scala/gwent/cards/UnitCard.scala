package cl.uchile.dcc
package gwent.cards

import gwent.Card

class UnitCard(val myName: String, var power: Int, row: String) extends Card {
  override val name: String = myName
  override val classification: String = "Unit"
  var basePower: Int = power
  var currentPower: Int = power
  val combatRow: String = row

  override def getName(): String = name

}
