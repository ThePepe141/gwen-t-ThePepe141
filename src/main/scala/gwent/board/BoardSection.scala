package cl.uchile.dcc
package gwent.board

import gwent.cards.{Card, CloseCombatUnit, RangedCombatUnit, SiegeCombatUnit, WeatherCard}

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

  /** The place where Cards go at the end of the Round
   */
  var graveyard: Array[Card] = Array[Card]()


  /** A function that puts a CloseCombatUnit in CloseCombatRow.
   *  
   * @param theCard The Card to be put.
   */
  def putCard(theCard: CloseCombatUnit): Unit = {
    CloseCombatRow = CloseCombatRow :+ theCard
  }

  /** A function that puts a RangedCombatUnit in RangedCombatRow.
   * 
   * @param theCard The Card to be put.
   */
  def putCard(theCard: RangedCombatUnit): Unit = {
    RangedCombatRow = RangedCombatRow :+ theCard
  }

  /** A function that puts a SiegeCombatUnit in SiegeCombatRow.
   * 
   * @param theCard The Card to be put.
   */
  def putCard(theCard: SiegeCombatUnit): Unit = {
    SiegeCombatRow = SiegeCombatRow :+ theCard
  }

  /** A function that puts a WeatherCard in Weather.
   * 
   * @param theCard The Card to be put.
   */
  def putCard(theCard: WeatherCard): Unit = {
    Weather = Array[WeatherCard](theCard)
  }


}
