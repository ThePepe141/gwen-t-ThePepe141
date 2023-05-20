package cl.uchile.dcc
package gwent.cards.units

import gwent.cards.{AbstractUnitCard, CloseCombatUnit}

class Geralt extends AbstractUnitCard(name = "Geralt of Rivia", _power = 15) with CloseCombatUnit {
  
  override def ability: Unit = println("I hate portals")
  
  

}
