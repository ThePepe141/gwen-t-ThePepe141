package cl.uchile.dcc
package gwent.cards.units

import gwent.cards.{AbstractUnitCard, CloseCombatUnit}

class TemerianInfantry extends AbstractUnitCard(name="Temerain Infantry", _power=5) with CloseCombatUnit {

  override def ability: Unit = {println("For Temreia!!!")}
}
