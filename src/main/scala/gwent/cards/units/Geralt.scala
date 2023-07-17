package cl.uchile.dcc
package gwent.cards.units

import gwent.cards.CloseCombatUnit

class Geralt extends CloseCombatUnit("Geralt of Rivia", 15){
  
  //Equals y hashCode -------------------------------------------

  /** A function that compares the types of two values.
   * 
   * @param that The other value to compare.
   *  @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Geralt]

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
    total = primo * total + classOf[Geralt].##
    total = primo * total + name.##
    total = primo * total + basePower
    total
  }
  //----------------------------------------------------------
  
  def ability: Unit = println("I hate portals")
  
  

}
