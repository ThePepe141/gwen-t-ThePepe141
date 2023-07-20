package cl.uchile.dcc
package gwent.board

import gwent.cards.{CardObserver, UnitCard, WeatherCard}
import gwent.cards.abilities.Ability
import gwent.cards.effects.Effect

trait BoardSubject {

  def addObserverCCR(observer: CardObserver): Unit

  def addObserverRCR(observer: CardObserver): Unit

  def addObserverSCR(observer: CardObserver): Unit

  def notifyObserversCCR(user: UnitCard, ability: Ability): Unit

  def notifyObserversCCR(user: WeatherCard, effect: Effect): Unit

  def notifyObserversRCR(user: UnitCard, ability: Ability): Unit

  def notifyObserversRCR(user: WeatherCard, effect: Effect): Unit

  def notifyObserversSCR(user: UnitCard, ability: Ability): Unit

  def notifyObserversSCR(user: WeatherCard, effect: Effect): Unit

}
