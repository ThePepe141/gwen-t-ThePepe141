package cl.uchile.dcc
package gwent.cards
import gwent.board.BoardSection

import gwent.cards.effects.{Effect, NullEffect}

/** A class that represents a Weather type Card.
 *
 * @param name The name of the Card.
 */
abstract class AbstractWeatherCard(val name: String) extends WeatherCard with Equals {

  /** The effect of the WeatherCard, NullEffect by default.
   * 
   */
  val effect: Effect = new NullEffect(List[Int](0))

  //Equals, hashCode y toString -------------------------------------------------------

  /** A function that compares the types of two values.
   * 
   * @param that The other value to compare.
   * @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractWeatherCard]

  /** A function that compares the structure of two objects.
   * 
   * @param that The object to compare.
   * @return True if the two objects have the same structure.
   */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)){
      val other = that.asInstanceOf[AbstractWeatherCard]
      (this eq other) || (this.getName == other.getName)
    }
    else{
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
    total = primo * total + classOf[AbstractWeatherCard].##
    total = primo * total + name.##
    total
  }

  override def toString: String = s"WeatherCard(name=$getName, affected row = Unknown)"
  // ---------------------------------------------------------------------------

  /** The effect this Card has in the Board.
   */
  override def weatherEffect: Unit = {println("Aqui iria mi efecto, si tuviera uno!!")}

  /** A function that set the weather of the Board to the one of the card.
   * 
   * @param section The BoardSection where the card is placed.
   */
  override def playOnBoardSection(section: BoardSection): Unit = {
    section.putCardWR(this)
  }

  
}
 