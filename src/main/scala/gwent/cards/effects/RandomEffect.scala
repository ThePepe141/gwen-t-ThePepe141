package cl.uchile.dcc
package gwent.cards.effects

import gwent.cards.{UnitCard, WeatherCard}

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** A class that represents the effect of  an effect between multiple effects.
 * 
 * @param effectList The list of effect to choose.
 */
class RandomEffect(val effectList: ListBuffer[Effect]) extends Effect {

  /**Choose and applies an specific effect of the list.
   * 
   * @param self The Card of the Effect.
   * @param target The Card to apply the Effect.
   */
  override def apply(self: WeatherCard, target: UnitCard): Unit = {
    val chosen = Random.between(0,effectList.length)
    effectList(chosen)(self, target)
  }

}
