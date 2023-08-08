package cl.uchile.dcc
package gwent.cards.weathers

import gwent.cards.AbstractWeatherCard
import scala.collection.mutable.ListBuffer

import gwent.cards.effects.{Effect, RandomEffect, NullEffect, PowerToOne}

/** A class that represent the UnderSiegeFire WeatherCard.
 * Each UnitCard has a 50/50 chance to get applied by PowerToOne.
 * 
 */
class Ragnarok extends AbstractWeatherCard("Ragnarok"){
  /** The NullEffect as a Effect
   */
  val effect1: Effect = new NullEffect
  
  /** The PowerToOne as a Effect
   */
  val effect2: Effect = new PowerToOne

  override val effect: Effect = new RandomEffect(ListBuffer[Effect](effect1, effect2))

  override val rows: List[Int] = List[Int](1,2,3)

  //Equals, hashCode y toString  -----------------------------------------------------

  /** A function that compares the types of two values.
   *
   * @param that The other value to compare.
   * @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Ragnarok]

  /** A function that compares the structure of two objects.
   *
   * @param that The object to compare.
   * @return True if the two objects have the same structure.
   */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      super.equals(that)
    }
    else {
      false
    }
  }

  /** A function that generates a hash value to an object.
   *
   * @return The hash value.
   */
  override def hashCode(): Int = {
    val primo = 31
    var total = 1
    total = primo * total + classOf[Ragnarok].##
    total = primo * total + name.##
    total
  }

  override def toString: String = s"UnderSiegeFire(affected row = All rows)"

  //--------------------------------------------------

}
