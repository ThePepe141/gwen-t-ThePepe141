package cl.uchile.dcc
package gwent.board

import gwent.cards.{CardObserver, UnitCard, WeatherCard}
import gwent.cards.abilities.Ability
import gwent.cards.effects.Effect

import cl.uchile.dcc.gwent.players.Player

import scala.collection.mutable.ListBuffer

/** A trait that represents the Subject aspect of a BoardSection.
 *
 */
trait BoardSubject {

  /** Adds a CardObserver to ObserverCCR.
   *
   * @param observer The CardObserver to add.
   */
  def addObserverCCR(observer: CardObserver): Unit

  /** Adds a CardObserver to ObserverRCR.
   *
   * @param observer The CardObserver to add.
   */
  def addObserverRCR(observer: CardObserver): Unit

  /** Adds a CardObserver to ObserverSCR.
   *
   * @param observer The CardObserver to add.
   */
  def addObserverSCR(observer: CardObserver): Unit

  /** A function that sends a message to all CardObservers in ObserverCCR.
   *
   * @param user The emissary of the ability to send.
   * @param ability The ability to send.
   */
  def notifyObserversCCR(user: UnitCard, ability: Ability): Unit

  /** A function that sends a message to all CardObservers in ObserverCCR.
   * 
   * @param user The emissary of the effect to send.
   * @param effect The effect to send.
   */
  def notifyObserversCCR(user: WeatherCard, effect: Effect): Unit

  /** A function that sends a message to all CardObservers in ObserverRCR.
   * 
   * @param user The emissary of the ability to send.
   * @param ability The ability to send.
   */
  def notifyObserversRCR(user: UnitCard, ability: Ability): Unit

  /** A function that sends a message to all CardObservers in ObserverRCR.
   * 
   * @param user The emissary of the effect to send.
   * @param effect The effect to send.
   */
  def notifyObserversRCR(user: WeatherCard, effect: Effect): Unit

  /** A function that sends a message to all CardObservers in ObserverSCR.
   * 
   * @param user The emissary of the ability to send.
   * @param ability The ability to send.
   */
  def notifyObserversSCR(user: UnitCard, ability: Ability): Unit

  /** A function that sends a message to all CardObservers in ObserverSCR.
   * 
   * @param user The emissary of the effect to send.
   * @param effect The effect to send.
   */
  def notifyObserversSCR(user: WeatherCard, effect: Effect): Unit

  


}
