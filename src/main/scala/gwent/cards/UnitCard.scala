package cl.uchile.dcc
package gwent.cards

trait UnitCard extends Card{
  val name: String
  var _power: Int
  val basePower: Int
  
  def getName: String
  def getBasePower: Int
  def currentPower: Int
  

}
