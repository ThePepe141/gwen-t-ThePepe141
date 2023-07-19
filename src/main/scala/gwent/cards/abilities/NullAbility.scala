package cl.uchile.dcc
package gwent.cards.abilities
import gwent.cards.Card

/** A class that represents no ability.
 * 
 */
class NullAbility extends Ability {

  override def apply(self: Card, target: Card): Unit = {
    //Nothing
  }

}
