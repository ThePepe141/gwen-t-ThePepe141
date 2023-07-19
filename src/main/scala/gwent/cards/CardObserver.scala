package cl.uchile.dcc
package gwent.cards

import gwent.board.BoardSubject

import cl.uchile.dcc.gwent.cards.abilities.Ability
import cl.uchile.dcc.gwent.cards.effects.Effect

trait CardObserver {
  
  def updateAbility(boardSubject: BoardSubject, ability: Ability): Unit
  
  def updateEffect(boardSubject: BoardSubject, effect: Effect): Unit
}
