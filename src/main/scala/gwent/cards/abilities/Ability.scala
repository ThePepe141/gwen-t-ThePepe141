package cl.uchile.dcc
package gwent.cards.abilities

import gwent.cards.{Card, UnitCard}

/** A trait that represents the abilities of the UnitCards.
 *
 */
trait Ability{


  /** Applies the ability on a Card.
   * 
   * @param self The Card of the ability.
   * @param target The Card to apply the ability.
   */
  def apply(self: UnitCard, target: UnitCard): Unit

}
