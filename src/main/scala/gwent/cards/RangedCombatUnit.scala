package cl.uchile.dcc
package gwent.cards
import gwent.board.BoardSection

/** A class that represents a Unit type Card that goes in the RangedCombatRow of a BoardSection.
 * 
 * @param name The name of the Card.
 * @param basePower The power in which the Card begins.
 */
class RangedCombatUnit(name: String, basePower: Int) extends AbstractUnitCard(name, basePower) {
  
  //Equals, hashCode y toString -------------------------------------------------------

  /** A function that compares the types of two values.
   * 
   * @param that The other value to compare.
   *  @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangedCombatUnit]

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
    total = primo * total + classOf[RangedCombatUnit].##
    total = primo * total + name.##
    total = primo * total + basePower
    total
  }

  override def toString: String = s"RangedCombatUnit(name=$getName, basePower=$getBasePower, currentPower=$currentPower, ability=Unknown)"
  // -------------------------------------------------------------------

  /** A function that put the card on the RangedCombatRow of the Section.
   *
   * @param section The BoardSection where the card is placed.
   */
  override def playOnBoardSection(section: BoardSection): Unit = {
    section.putCardRCR(this)
  }
}
