package cl.uchile.dcc
package gwent.cards

import gwent.cards.effects.NullEffect

/** A trait that represents a Card of type Weather.
 */
trait WeatherCard extends Card {
  
  /** The effect the Card has on the Board.
   */
  def weatherEffect: Unit

}
