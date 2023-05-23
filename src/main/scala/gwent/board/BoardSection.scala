package cl.uchile.dcc
package gwent.board

import gwent.cards.{CloseCombatUnit, RangedCombatUnit, SiegeCombatUnit, WeatherCard}

/** A class that represents a section of a Board.
 */
class BoardSection {

  /** The row for the Close Combat UnitCards.
   */
  var CloseCombatRow: Array[CloseCombatUnit] = Array[CloseCombatUnit]()

  /** The row for the Ranged Combat UnitCards.
   */
  var RangedCombatRow: Array[RangedCombatUnit] = Array[RangedCombatUnit]()

  /** The row for the Siege Combat UnitCards.
   */
  var SiegeCombatRow: Array[SiegeCombatUnit] = Array[SiegeCombatUnit]()

  /** The weather currently being played on the Board.
   */
  var Weather: Array[WeatherCard] = Array[WeatherCard]()

}
