package cl.uchile.dcc
package gwent.cards.abilities
import gwent.cards.UnitCard

import scala.collection.mutable.ListBuffer

/** An Abilities compose of multiple abilities
 * 
 * @param listAbilities The list ob abilities.
 */
class MultipleAbilities(val listAbilities: ListBuffer[Ability]) extends Ability {

  /** Applies the list of abilities to a target Card in the same order as the list. 
   * 
   * @param self The Card of the ability.
   * @param target The Card to apply the ability.
   */
  override def apply(self: UnitCard, target: UnitCard): Unit = {
    for (ability<- listAbilities){
      ability(self, target)
    }
  }

}
