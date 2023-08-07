package cl.uchile.dcc
package gwent.cards.effects
import gwent.cards.{UnitCard, WeatherCard}
import scala.collection.mutable.ListBuffer

/** A class that represents a composition of effects.
 *
 * @param effectList The list of effects to apply.
 */
class MultipleEffect(var effectList: ListBuffer[Effect]) extends Effect {

  /** Applies the effects in the order of the list to a card.
   *
   * @param self The Card of the Effect.
   * @param target The Card to apply the Effect.
   */
  override def effect(self: WeatherCard, target: UnitCard): Unit = {
    for (theEffect <- effectList){
      theEffect.effect(self, target)
    }
  }

}
