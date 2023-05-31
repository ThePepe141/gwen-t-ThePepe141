package cl.uchile.dcc
package gwent.cards.units

import gwent.cards.CloseCombatUnit

class Geralt extends CloseCombatUnit(name = "Geralt of Rivia", basePower = 15){
  
  def ability: Unit = println("I hate portals")
  
  

}
