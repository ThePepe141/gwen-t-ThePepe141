package cl.uchile.dcc
package gwent.board

import gwent.cards.{CardObserver, UnitCard, WeatherCard}

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

  override def notifyObserversCCR(user: UnitCard, ability: Ability): Unit = {
    for (observer <- observersCCR){
      observer.updateAbility(this, user, ability)
    }
  }

  override def notifyObserversRCR(user: UnitCard, ability: Ability): Unit = {
    for (observer <- observersRCR) {
      observer.updateAbility(this, user, ability)
    }
  }

  override def notifyObserversSCR(user: UnitCard, ability: Ability): Unit = {
    for (observer <- observersSCR) {
      observer.updateAbility(this, user, ability)
    }
  }

  override def notifyObserversCCR(user: WeatherCard, effect: Effect): Unit = {
    for (observer <- observersCCR) {
      observer.updateEffect(this, user, effect)
    }
  }

  override def notifyObserversRCR(user: WeatherCard, effect: Effect): Unit = {
    for (observer <- observersRCR) {
      observer.updateEffect(this, user, effect)
    }
  }

  override def notifyObserversSCR(user: WeatherCard, effect: Effect): Unit = {
    for (observer <- observersSCR) {
      observer.updateEffect(this, user, effect)
    }
  }
}
