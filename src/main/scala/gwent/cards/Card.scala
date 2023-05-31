package cl.uchile.dcc
package gwent.cards

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
}
