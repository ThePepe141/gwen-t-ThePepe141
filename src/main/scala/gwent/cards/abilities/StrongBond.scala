package cl.uchile.dcc
package gwent.cards.abilities

import gwent.cards.{AbstractUnitCard, Card, UnitCard}

/** A class that represents the Strong Bond Ability
 *
 * Multiply the currentPower of the units of the same class by the amount of them in the row.
 */
class StrongBond(val bros: UnitCard) extends Ability {


  override def apply(self: UnitCard, target: UnitCard): Unit = {
    //Bro
    target.setCurrentPower(target.currentPower * 2)
  }

}
