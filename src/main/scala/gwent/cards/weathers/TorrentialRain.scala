package cl.uchile.dcc
package gwent.cards.weathers

import gwent.cards.AbstractWeatherCard
import gwent.cards.effects.{Effect, PowerToOne}

/** A class that represent the Torrential Rain Weather Card.
 * Effect: PowerToOne on Siege Combat Row.
 */
class TorrentialRain extends AbstractWeatherCard("Torrential Rain"){

  override val effect: Effect = new PowerToOne

  override val rows: List[Int] = List[Int](3)
  
  //Equals, hashCode y toString  -----------------------------------------------------

  /** A function that compares the types of two values.
   *
   * @param that The other value to compare.
   * @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[TorrentialRain]

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
    total = primo * total + classOf[TorrentialRain].##
    total = primo * total + name.##
    total
  }

  override def toString: String = s"TorrentialRain(affected row = SiegeCombatRow)"

  //--------------------------------------------------

  override def weatherEffect: Unit = println("It was sunny just moments ago!")

}
