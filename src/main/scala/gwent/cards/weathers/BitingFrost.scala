package cl.uchile.dcc
package gwent.cards.weathers

import gwent.cards.AbstractWeatherCard

import gwent.cards.effects.{Effect, PowerToOne}

/** A class that represents the Biting Frost Weather Card.
 * Effect: PowerToOne on Close Combat Row.
 */
class BitingFrost extends AbstractWeatherCard("Biting Frost"){


  override val effect: Effect = new PowerToOne

  override val rows: List[Int] = List[Int](1)
  
  //Equals, hashCode y toString -----------------------------------------------------

  /** A function that compares the types of two values.
   *
   * @param that The other value to compare.
   * @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[BitingFrost]

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
    total = primo * total + classOf[BitingFrost].##
    total = primo * total + name.##
    total
  }

  override def toString: String = s"BitingFrost(affected row = CloseCombatRow)"
  
  //--------------------------------------------------

  /** Reduce the currentPower of units in the opposite BoardSection to the minimum.
   */
  override def weatherEffect: Unit = println("It´s Cold!")
}
