package cl.uchile.dcc
package gwent.cards
import gwent.board.BoardSection

/** A class that represents a Unit type Card that goes in the SiegeCombatRow of a BoardSection.
 * 
 * @param name The name of the Card.
 * @param basePower The power in which the Card begins.
 */
class SiegeCombatUnit(name: String, basePower: Int) extends AbstractUnitCard(name, basePower) {
  
  //Equals, hashCode y toString ----------------------------------------------------------------

  /** A function that compares the types of two values.
   * 
   * @param that The other value to compare.
   *  @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCombatUnit]

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
    total = primo * total + classOf[SiegeCombatUnit].##
    total = primo * total + name.##
    total = primo * total + basePower
    total
  }

  override def toString: String = s"SiegeCombatUnit(name=$getName, basePower=$getBasePower, currentPower=$currentPower, ability=Unknown"
  //----------------------------------------------------------------------

  /** A function that put the card on the SiegeCombatRow of the Section.
   * 
   * @param section The BoardSection where the card is placed.
   */
  override def playOnBoardSection(section: BoardSection): Unit = {
    section.putCardSCR(this)
  }
}
