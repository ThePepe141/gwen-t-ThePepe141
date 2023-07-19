package cl.uchile.dcc
package gwent.cards

import gwent.board.BoardSubject
import gwent.cards.abilities.Ability

import gwent.cards.effects.Effect

trait CardObserver {

  def updateAbility(boardSubject:BoardSubject, ability: Ability): Unit
  
  def updateEffect(boardSubject: BoardSubject,effect: Effect): Unit

}
