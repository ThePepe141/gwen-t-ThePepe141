package cl.uchile.dcc
package gwent.cards.weathers

import gwent.cards.AbstractWeatherCard

class SunnyDay extends AbstractWeatherCard("Sunny Day"){
  
  //Equals, hashCode y toString -------------------------------------------

  /** A function that compares the types of two values.
   * 
   * @param that The other value to compare.
   *  @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SunnyDay]

  /** A function that compares the structure of two objects.
   * 
   * @param that The object to compare.
   *  @return True if the two objects have the same structure.
   */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)){
      super.equals(that)
    }
    else{
      false
    }
  }
  
  /** A function that generates a hash value to an object.
   * 
   *  @return The hash value.
   */
  override def hashCode(): Int = {
    val primo = 31
    var total = 1
    total = primo * total + classOf[SunnyDay].##
    total = primo * total + name.##
    total
  }

  override def toString: String = s"SunnyDay(affected row = All rows"

  //-----------------------------------------------------------------
  /** Clear the current weatherEffect in the Board
   */
  override def weatherEffect: Unit = println("It´s sunny!")
}
