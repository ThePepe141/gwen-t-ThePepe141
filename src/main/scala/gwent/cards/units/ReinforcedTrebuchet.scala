package cl.uchile.dcc
package gwent.cards.units

import gwent.cards.{AbstractUnitCard, SiegeCombatUnit}

class ReinforcedTrebuchet extends AbstractUnitCard(name="Reainforced Trebuchet", _power = 8) with SiegeCombatUnit {

  override def ability: Unit = { println("RELOAAAAD!!!!") }

}
