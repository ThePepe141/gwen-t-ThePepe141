package cl.uchile.dcc
package gwent.cards

trait UnitCard extends Card{
  var _power: Int
  val basePower: Int
  
  def getBasePower: Int
  def currentPower: Int
  def resetPower: Unit
  

}
