package cl.uchile.dcc
package gwent.cards.abilities

import gwent.cards.Card

/** A trait that represents the abilities of the cards.
 *
 */
trait Ability{


  def apply(self: Card, target: Card): Unit

}
