package cl.uchile.dcc
package gwent.cards

/** A trait that represents a Card.
 */
trait Card {
  
  /** The name of the Card.
   */
  val name: String

  /** Getter of name value.
   *
   * @return name value.
   */
  def getName: String = name
}
