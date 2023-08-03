package cl.uchile.dcc
package gwent.cards

import gwent.cards.abilities.{Ability, NullAbility}

import cl.uchile.dcc.gwent.board.BoardSubject
import cl.uchile.dcc.gwent.cards.effects.Effect


/** A class that represents a Unit type Card.
 *
 * It is abstract because ability its not define.
 *
 * @param name The name of the Card.
 * @param basePower The power in which the Card begins.
 */
abstract class AbstractUnitCard(override protected val name: String, val basePower: Int) extends UnitCard with CardObserver {

  /** The current power of the Card.
   *
   * This variable specify the current power of the Card including abilities, weather, etc.
   */
  var _power: Int = basePower

  /** The ability of the card.
   *
   * Null ability by default.
   */
  val ability: Ability = new NullAbility


  //Equals, hashCode y toString -----------------------------------------------------------

  /** A function that compares the types of two values.
   *
   * @param that The other value to compare.
   * @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractUnitCard]

  /** A function that compares the structure of two objects.
   *
   * @param that The object to compare.
   * @return True if the two objects have the same structure.
   */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)){
      val other = that.asInstanceOf[AbstractUnitCard]
      (this eq other) || (this.getName == other.getName && this.getBasePower == other.getBasePower && this.currentPower == other.currentPower)
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
    total = primo * total + classOf[AbstractUnitCard].##
    total = primo * total + name.##
    total = primo * total + basePower
    total
  }
  
  override def toString: String = s"AbstractUnitCard(name=$getName, basePower=$getBasePower, currentPower=$currentPower, ability:None)"
  
  //Getters y Setters ----------------------------------------------

  /** Getter of basePower param.
   *
   * @return basePower.
   */
  override def getBasePower: Int = basePower

  /** Getter of _power param.
   *
   * @return _power.
   */
  override def currentPower: Int = _power

  /** Setter of _power param.
   *
   * Change _power to a specify value.
   *
   * @param newPower The new power that the Card will posses.
   */
  override def setCurrentPower(newPower: Int): Unit = {
    _power = math.max(0, newPower)
  }

  /** Setter of _power param.
   *
   * Set the _power variable to its basePower value.
   */
  override def resetPower: Unit = { _power = this.getBasePower }

  //Observer methods ---------------------------------------------------------------
  
  override def updateAbility(boardSubject: BoardSubject,theOne: UnitCard, ability: Ability): Unit = {
    //something
    ability.apply(theOne, this)
  }

  override def updateEffect(boardSubject: BoardSubject, theOne: WeatherCard, effect: Effect): Unit = {
    //something
    effect.effect(theOne, this)
  }
  
  
}
