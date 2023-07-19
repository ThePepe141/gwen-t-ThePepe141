package cl.uchile.dcc
package gwent.cards.abilities
import gwent.cards.{Card, UnitCard}

/** A class that represents no ability.
 * 
 */
class NullAbility extends Ability {

  override def apply(self: UnitCard, target: UnitCard): Unit = {
    //Nothing
  }

}
