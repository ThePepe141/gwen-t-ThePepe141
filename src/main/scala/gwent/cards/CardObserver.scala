package cl.uchile.dcc
package gwent.cards

import gwent.board.BoardSubject

import cl.uchile.dcc.gwent.cards.abilities.Ability
import cl.uchile.dcc.gwent.cards.effects.Effect

/** A trait that represents AbstractUnitCard as an Observer class.
 * 
 */
trait CardObserver {

  
  /** Applies the ability send by boardSubject.
   * 
   * @param boardSubject The BoardSection of this current Card.
   * @param ability The ability to apply.
   */
  def updateAbility(boardSubject: BoardSubject, theOne: UnitCard, ability: Ability): Unit

  /** Applies the effect send by boardSubject.
   * 
   * @param boardSubject The BoardSection of this current Card.
   * @param effect The ability to apply.
   */
  def updateEffect(boardSubject: BoardSubject, theOne: WeatherCard, effect: Effect): Unit
  
}
