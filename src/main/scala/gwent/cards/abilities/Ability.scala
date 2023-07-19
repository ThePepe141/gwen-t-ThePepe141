package cl.uchile.dcc
package gwent.cards.abilities

import gwent.cards.{Card, UnitCard}

/** A trait that represents the abilities of the cards.
 *
 */
trait Ability{


  def apply(self: UnitCard, target: UnitCard): Unit

}
