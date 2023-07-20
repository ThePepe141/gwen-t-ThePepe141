package cl.uchile.dcc
package gwent.cards

/** A trait that represents a Card of type Unit.
 */
trait UnitCard extends Card{
  
  /** The power the Card currently posses.
   */
  protected var _power: Int
  
  /** The power which the Card begins with.
   */
  protected val basePower: Int

  /** Getter of basePower param.
   * 
   * @return basePower.
   */
  def getBasePower: Int

  /** Getter of the _power param.
   * 
   * @return _power.
   */
  def currentPower: Int

  /** Setter of the _power param.
   * 
   * @param newPower The new _power.
   */
  def setCurrentPower(newPower: Int): Unit

  /** Setter of the _power param.
   * 
   *  Change _power to its original value.
   */
  def resetPower: Unit
  

}
