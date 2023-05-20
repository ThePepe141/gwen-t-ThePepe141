package cl.uchile.dcc
package gwent.board

import gwent.cards.{CloseCombatUnit, RangedCombatUnit, SiegeCombatUnit, WeatherCard}

class BoardSection {

  var CloseCombatRow: Array[CloseCombatUnit] = Array[CloseCombatUnit]()
  var RangedCombatRow: Array[RangedCombatUnit] = Array[RangedCombatUnit]()
  var SiegeCombatRow: Array[SiegeCombatUnit] = Array[SiegeCombatUnit]()
  var Weather: Array[WeatherCard] = Array[WeatherCard]()

}
