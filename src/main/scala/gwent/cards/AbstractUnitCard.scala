package cl.uchile.dcc
package gwent.cards

/** A class that represents a Unit type Card.
 *
 * It is abstract because ability its not define.
 *
 * @param name The name of the Card.
 * @param basePower The power in which the Card begins.
 */
abstract class AbstractUnitCard(override val name: String, val basePower: Int) extends UnitCard {

  /** The current power of the Card.
   *
   * This variable specify the current power of the Card including abilities, weather, etc.
   */
  var _power: Int = basePower

  /** Getter of basePower value.
   *
   * @return basePower value.
   */
  override def getBasePower: Int = basePower

  /** Getter of _power variable.
   *
   * @return _power variable.
   */
  override def currentPower: Int = _power

  /** Setter of _power variable.
   *
   * Change _power to a specify value.
   *
   * @param newPower The new power that the Card will posses.
   */
  def currentPower_=(newPower: Int): Unit = {
    _power = math.max(0, newPower)
  }

  /** Setter of _power variable.
   *
   * Set the _power variable to its basePower value.
   */
  override def resetPower: Unit = { _power = this.getBasePower }


}
