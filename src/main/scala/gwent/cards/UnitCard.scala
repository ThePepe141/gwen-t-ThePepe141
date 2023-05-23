package cl.uchile.dcc
package gwent.cards

/** A trait that represents a Card of type Unit.
 */
trait UnitCard extends Card{
  
  /** The power the Card currently posses.
   */
  var _power: Int
  
  /** The power which the Card begins with.
   */
  val basePower: Int

  /** Getter of basePower value.
   * 
   * @return basePower value.
   */
  def getBasePower: Int

  /** Getter of the _power variable.
   * 
   * @return _power variable.
   */
  def currentPower: Int

  /** Setter of the _power variable.
   * 
   *  Change _power to its original value.
   */
  def resetPower: Unit
  

}
