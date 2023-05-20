package cl.uchile.dcc
package gwent.cards.units

import gwent.cards.{RangedCombatUnit, AbstractUnitCard}

class RedanianArcher extends AbstractUnitCard(name="Redanian Archer", _power = 3) with RangedCombatUnit{

  override def ability: Unit = {println("Hold!, FIREEE!!!")}

}
