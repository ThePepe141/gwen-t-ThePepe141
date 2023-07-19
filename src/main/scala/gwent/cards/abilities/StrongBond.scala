package cl.uchile.dcc
package gwent.cards.abilities

import gwent.cards.{AbstractUnitCard, Card}

import cl.uchile.dcc.gwent.cards.observer.AbstractSubject

/** A class that represents the Strong Bond Ability
 *
 * Multiply the currentPower of the units of the same class by the amount of them in the row.
 */
class StrongBond(val bros: AbstractUnitCard) extends Ability {


  override def apply(self: Card, target: Card): Unit = {
    //Bro
  }

}
