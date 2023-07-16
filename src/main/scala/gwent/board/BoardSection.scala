package cl.uchile.dcc
package gwent.board

import gwent.cards.{AbstractUnitCard, Card, CloseCombatUnit, RangedCombatUnit, SiegeCombatUnit, WeatherCard}

import scala.collection.mutable.ListBuffer

/** A class that represents a section of a Board.
 */
class BoardSection {

  /** The row for the Close Combat UnitCards.
   */
  private var CloseCombatRow: ListBuffer[CloseCombatUnit] = ListBuffer[CloseCombatUnit]()

  /** The row for the Ranged Combat UnitCards.
   */
  private var RangedCombatRow: ListBuffer[RangedCombatUnit] = ListBuffer[RangedCombatUnit]()

  /** The row for the Siege Combat UnitCards.
   */
  private var SiegeCombatRow: ListBuffer[SiegeCombatUnit] = ListBuffer[SiegeCombatUnit]()

  /** The weather currently being played on the Board.
   */
  private var Weather: ListBuffer[WeatherCard] = ListBuffer[WeatherCard]()

  /** The place where Cards go at the end of the Round
   */
  private var Graveyard: ListBuffer[AbstractUnitCard] = ListBuffer[AbstractUnitCard]()

  /**The total power of the CLoseCombatRow.
   */
  private var CCRpower: Int = 0

  /** The total power of the RangedCombatRow.
   */
  private var RCRpower: Int = 0

  /** The total power of the SiegeCombatRow
   */
  private var SCRpower: Int = 0

  /** The power of the combined rows.
   */
  private var totalPower: Int = 0

  // Getters y Setters -------------------------------------------------------

  /** Getter of CloseCombatRow.
   *
   * @param show boolean that represents the choice of printing the cards.
   * @return the cards on CloseCombatRow.
   */
  def getCloseCombatRow(show: Boolean): ListBuffer[CloseCombatUnit] = {
    if (show){
      for (card <- CloseCombatRow) {
        println(s"Name: ${card.getName}, Power: ${card.currentPower}")
      }
    }
    CloseCombatRow
  }

  /** Getter of RangedCombatRow.
   *
   * @param show boolean that represents the choice of printing the cards.
   * @return the cards on RangedCombatRow.
   */
  def getRangedCombatRow(show: Boolean): ListBuffer[RangedCombatUnit] = {
    if(show){
      for (card <- RangedCombatRow) {
        println(s"Name: ${card.getName}, Power: ${card.currentPower}")
      }
    }
    RangedCombatRow
  }

  /** Getter of SiegeCombatRow.
   *
   * @param show boolean that represents the choice of printing the cards.
   * @return the cards on SiegeCombatRow.
   */
  def getSiegeCombatRow(show: Boolean): ListBuffer[SiegeCombatUnit] = {
    if (show) {
      for (card <- SiegeCombatRow) {
        println(s"Name: ${card.getName}, Power: ${card.currentPower}")
      }
    }
    SiegeCombatRow
  }

  /** Getter of Weather.
   *
   * @return the weather on the match.
   */
  def getWeather: WeatherCard = Weather(0)

  /** Getter of Graveyard.
   *
   * @param show boolean that represents the choice of printing the cards.
   * @return the cards in the Graveyard.
   */
  def getGraveyard(show: Boolean): ListBuffer[AbstractUnitCard] = {
    if (show){
      for (card <- Graveyard){
        println(s"Name: ${card.getName}, Power: ${card.currentPower}")
      }
    }
    Graveyard
  }

  /** Setter of CCRpower param.
   *
   * Updates the total power of CloseCombatRow.
   *
   */
  def updateCCRpower: Int = {
    CCRpower = 0
    for (card <- CloseCombatRow){
      CCRpower += card.currentPower
    }
    CCRpower
  }

  /** Getter of CCRpower param.
   *
   * @return the total power of the CloseCombatRow.
   */
  def getCCRpower: Int = CCRpower

  /** Setter of RCRpower param.
   *
   * Updates the total power of RangedCombatRow.
   *
   */
  def updateRCRpower: Int = {
    RCRpower = 0
    for (card <- RangedCombatRow) {
      RCRpower += card.currentPower
    }
    RCRpower
  }

  /** Getter of RCRpower param.
   *
   * @return the total power of the RangedCombatRow.
   */
  def getRCRpower: Int = RCRpower

  /** Setter of SCRpower param.
   *
   * Updates the total power of SiegeCombatRow.
   *
   */
  def updateSCRpower: Int = {
    SCRpower = 0
    for (card <- SiegeCombatRow) {
      SCRpower += card.currentPower
    }
    SCRpower
  }

  /** Getter of SCRpower param.
   *
   * @return the total power of the SiegeCombatRow.
   */
  def getSCRpower: Int = SCRpower

  /** Setter of totalPower param.
   *
   * Updates the total power on the BoardSection.
   *
   */
  def updateTotalPower: Unit ={
    totalPower = updateCCRpower + updateRCRpower + updateSCRpower
  }

  /** Getter of the totalPower param.
   *
   * @return the total power of the BoardSection.
   */
  def getTotalPower: Int = totalPower

  //Card movements ----------------------------------------------

  /** A function that puts a CloseCombatUnit in CloseCombatRow.
   *  
   * @param theCard The Card to be put.
   */
  def putCard(theCard: CloseCombatUnit): Unit = {
    CloseCombatRow = CloseCombatRow :+ theCard
    updateTotalPower
  }

  /** A function that puts a RangedCombatUnit in RangedCombatRow.
   * 
   * @param theCard The Card to be put.
   */
  def putCard(theCard: RangedCombatUnit): Unit = {
    RangedCombatRow = RangedCombatRow :+ theCard
    updateTotalPower
  }

  /** A function that puts a SiegeCombatUnit in SiegeCombatRow.
   * 
   * @param theCard The Card to be put.
   */
  def putCard(theCard: SiegeCombatUnit): Unit = {
    SiegeCombatRow = SiegeCombatRow :+ theCard
    updateTotalPower
  }

  /** A function that puts a WeatherCard in Weather.
   * 
   * @param theCard The Card to be put.
   */
  def putCard(theCard: WeatherCard): Unit = {
    Weather = ListBuffer[WeatherCard](theCard)
  }


}
