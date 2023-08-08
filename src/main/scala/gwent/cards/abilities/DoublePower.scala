package cl.uchile.dcc
package gwent.cards.abilities
import gwent.cards.UnitCard

/** A class that represents the ability to double the power of a UnitCard.
 * 
 */
class DoublePower extends Ability {

  /** Applies the ability to a UnitCard.
   * 
   * @param self The Card of the ability.
   * @param target The Card to apply the ability.
   */
  override def apply(self: UnitCard, target: UnitCard): Unit = {
    target.setCurrentPower(target.currentPower * 2)
  }

}
