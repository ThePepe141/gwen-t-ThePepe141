package cl.uchile.dcc
package gwent.cards.weathers

import gwent.cards.AbstractWeatherCard
import gwent.cards.effects.{Effect, PowerToOne}

class ImpenetrableFog extends AbstractWeatherCard("Impenetrable Fog"){


  override val effect: Effect = new PowerToOne(List[Int](2))

  //Equals, hashCode y toString  -----------------------------------------------------

  /** A function that compares the types of two values.
   *
   * @param that The other value to compare.
   * @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[ImpenetrableFog]

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
    total = primo * total + classOf[ImpenetrableFog].##
    total = primo * total + name.##
    total
  }

  override def toString: String = s"ImpenetrableFog(affected row = RangedCombatRow)"

  //--------------------------------------------------

  override def weatherEffect: Unit = println("I don´t see sh#t")
}
