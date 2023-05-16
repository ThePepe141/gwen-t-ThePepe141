package cl.uchile.dcc
package gwent.cards

class Geralt extends AbstractUnitCard(name = "Geralt of Rivia", _power = 15) with CloseCombatUnit {
  override val basePower: Int = _power

  override def getName: String = name

  override def getBasePower: Int = basePower

  override def currentPower: Int = _power

  override def ability: Unit = println("I hate portals")
  
  

}
