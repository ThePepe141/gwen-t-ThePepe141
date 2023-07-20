package cl.uchile.dcc
package gwent.cards.abilities
import gwent.cards.{Card, UnitCard}

/** A class that represents the Morale Boost Ability
 *
 * Boost all units on the row by 1.
 */
class MoraleBoost extends Ability {
  
  override def apply(self: UnitCard, target: UnitCard): Unit = {
    //Boost
    target.setCurrentPower(target.currentPower + 1)
  }

}
