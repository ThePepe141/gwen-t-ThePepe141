package cl.uchile.dcc
package gwent.cards
import gwent.board.BoardSection

/** A class that represents a Unit type Card that goes in the ClosCombatRow of a BoardSection.
 * 
 * @param name The name of the Card.
 * @param basePower The power in which the Card begins.
 */
class CloseCombatUnit(name: String, basePower: Int) extends AbstractUnitCard(name, basePower) {

  /** A function that put the card on the CloseCombatRow of the Section.
   * 
   * @param section The BoardSection where the card is placed.
   */
  override def playOnBoardSection(section: BoardSection): Unit = {
    section.putCardCCR(this)
  }

}
