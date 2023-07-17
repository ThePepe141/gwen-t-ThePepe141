package cl.uchile.dcc
package gwent.cards.units

import gwent.cards.CloseCombatUnit

class TemerianInfantry extends CloseCombatUnit(name="Temerain Infantry", basePower = 5) {
  
  //Equals ---------------------------------------------------------

  /** A function that compares the types of two values.
   * 
   * @param that The other value to compare.
   *  @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[TemerianInfantry]

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
  //-----------------------------------------------------------------------
  
}
