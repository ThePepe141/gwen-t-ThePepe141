package cl.uchile.dcc
package gwent.cards.abilities

import gwent.cards.{AbstractUnitCard, Card, UnitCard}

/** A class that represents the Strong Bond Ability
 * Multiply the currentPower of the units of the same class by the amount of them in the row.
 * Include self.
 */
class StrongBond extends Ability {


  override def apply(self: UnitCard, target: UnitCard): Unit = {
    //Bro
    if (self.getClass==target.getClass){
      self.setCurrentPower(self.currentPower * 2)
      target.setCurrentPower(target.currentPower * 2)
    }
  }

}
