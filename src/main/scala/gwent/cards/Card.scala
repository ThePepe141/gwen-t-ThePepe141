package cl.uchile.dcc
package gwent.cards

import gwent.board.BoardSection

/** A trait that represents a Card.
 */
trait Card {
  
  /** The name of the Card.
   */
  protected val name: String

  /** Getter of name param.
   *
   * @return name.
   */
  def getName: String = name

  /** A function that put the card on the BoardSection.
   * 
   * @param section The BoardSection where the card is placed.
   */
  def playOnBoardSection(section: BoardSection): Unit
  
}
