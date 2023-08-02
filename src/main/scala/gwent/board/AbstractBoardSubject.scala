package cl.uchile.dcc
package gwent.board

import gwent.cards.{Card, CardObserver, UnitCard, WeatherCard}
import gwent.cards.abilities.Ability
import gwent.cards.effects.Effect

import cl.uchile.dcc.gwent.players.Player

import scala.collection.mutable.ListBuffer

/** An abstract class the implements all methods defined in the trait BoardSubject.
 * It also add the list of observers for each rows.
 */
abstract class AbstractBoardSubject extends BoardSubject {

  /** A List of all cards in the CLoseCombatRow as CardObservers.
   * It start empty.
   */
  private var observersCCR: List[CardObserver] = Nil

  /** A List of all cards in the RangedCombatRow as CardObservers.
   * It start empty.
   */
  private var observersRCR: List[CardObserver] = Nil

  /** A List of all cards in the SiegeCombatRow as CardObservers.
   * It start empty.
   */
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
