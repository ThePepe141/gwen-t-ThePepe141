package cl.uchile.dcc
package gwent.cards

class Witcher (override val name: String, var _power: Int) extends UnitCard with CloseCombatUnit {
  override val basePower: Int = _power

  override def getName: String = name

  override def getRow: String = row

  override def getBasePower: Int = basePower

  override def currentPower: Int = _power

  override def ability: Unit = println("I hate portals")
  
  

}
