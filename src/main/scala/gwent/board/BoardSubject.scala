package cl.uchile.dcc
package gwent.board

import gwent.cards.{CardObserver, UnitCard}
import gwent.cards.abilities.Ability
import gwent.cards.effects.Effect

trait BoardSubject {

  def addObserverCCR(observer: CardObserver): Unit

  def addObserverRCR(observer: CardObserver): Unit

  def addObserverSCR(observer: CardObserver): Unit

  def notifyObserversCCR(ability: Ability): Unit

  def notifyObserversCCR(effect: Effect): Unit

  def notifyObserversRCR(ability: Ability): Unit

  def notifyObserversRCR(effect: Effect): Unit

  def notifyObserversSCR(ability: Ability): Unit

  def notifyObserversSCR(effect: Effect): Unit

}
