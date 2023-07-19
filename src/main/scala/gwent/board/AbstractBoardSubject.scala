package cl.uchile.dcc
package gwent.board

import gwent.cards.CardObserver

import cl.uchile.dcc.gwent.cards.abilities.Ability
import cl.uchile.dcc.gwent.cards.effects.Effect

class AbstractBoardSubject extends BoardSubject {

  private var observersCCR: List[CardObserver] = Nil
  private var observersRCR: List[CardObserver] = Nil
  private var observersSCR: List[CardObserver] = Nil

  override def addObserverCCR(observer: CardObserver): Unit = {
    observersCCR = observer :: observersCCR
  }

  override def addObserverRCR(observer: CardObserver): Unit = {
    observersRCR = observer :: observersRCR
  }

  override def addObserverSCR(observer: CardObserver): Unit = {
    observersSCR = observer :: observersSCR
  }

  override def notifyObserversCCR(ability: Ability): Unit = {
    for (observer <- observersCCR){
      observer.updateAbility(this, ability)
    }
  }

  override def notifyObserversRCR(ability: Ability): Unit = {
    for (observer <- observersRCR) {
      observer.updateAbility(this, ability)
    }
  }

  override def notifyObserversSCR(ability: Ability): Unit = {
    for (observer <- observersSCR) {
      observer.updateAbility(this, ability)
    }
  }

  override def notifyObserversCCR(effect: Effect): Unit = {
    for (observer <- observersCCR) {
      observer.updateEffect(this, effect)
    }
  }

  override def notifyObserversRCR(effect: Effect): Unit = {
    for (observer <- observersRCR) {
      observer.updateEffect(this, effect)
    }
  }

  override def notifyObserversSCR(effect: Effect): Unit = {
    for (observer <- observersSCR) {
      observer.updateEffect(this, effect)
    }
  }
}
