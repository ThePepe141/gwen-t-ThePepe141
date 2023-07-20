package cl.uchile.dcc
package gwent.board

import gwent.cards.{AbstractUnitCard, Card, CloseCombatUnit, RangedCombatUnit, SiegeCombatUnit, WeatherCard}

import scala.collection.mutable.ListBuffer

/** A class that represents a section of a Board.
 */
class BoardSection(board: Board) extends AbstractBoardSubject {

  /** The row for the Close Combat UnitCards.
   */
  private var CloseCombatRow: ListBuffer[CloseCombatUnit] = ListBuffer[CloseCombatUnit]()

  /** The row for the Ranged Combat UnitCards.
   */
  private var RangedCombatRow: ListBuffer[RangedCombatUnit] = ListBuffer[RangedCombatUnit]()

  /** The row for the Siege Combat UnitCards.
   */
  private var SiegeCombatRow: ListBuffer[SiegeCombatUnit] = ListBuffer[SiegeCombatUnit]()
  

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
   * @return the cards on CloseCombatRow.
   */
  def getCloseCombatRow: ListBuffer[CloseCombatUnit] = CloseCombatRow

  /** Getter of RangedCombatRow.
   *
   * @return the cards on RangedCombatRow.
   */
  def getRangedCombatRow: ListBuffer[RangedCombatUnit] = RangedCombatRow
  

  /** Getter of SiegeCombatRow.
   *
   * @return the cards on SiegeCombatRow.
   */
  def getSiegeCombatRow: ListBuffer[SiegeCombatUnit] = SiegeCombatRow
  

  /** Getter of Graveyard.
   *
   * @return the cards in the Graveyard.
   */
  def getGraveyard: ListBuffer[AbstractUnitCard] = Graveyard
  

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
  def putCardCCR(theCard: CloseCombatUnit): Unit = {
    CloseCombatRow = CloseCombatRow :+ theCard
    addObserverCCR(theCard)
    updateTotalPower
    println(s"Name: ${theCard.getName}, Power: ${theCard.currentPower} joined the battlefield")
  }

  /** A function that puts a RangedCombatUnit in RangedCombatRow.
   * 
   * @param theCard The Card to be put.
   */
  def putCardRCR(theCard: RangedCombatUnit): Unit = {
    RangedCombatRow = RangedCombatRow :+ theCard
    addObserverRCR(theCard)
    updateTotalPower
    println(s"Name: ${theCard.getName}, Power: ${theCard.currentPower} joined the battlefield")
  }

  /** A function that puts a SiegeCombatUnit in SiegeCombatRow.
   * 
   * @param theCard The Card to be put.
   */
  def putCardSCR(theCard: SiegeCombatUnit): Unit = {
    SiegeCombatRow = SiegeCombatRow :+ theCard
    addObserverSCR(theCard)
    updateTotalPower
    println(s"Name: ${theCard.getName}, Power: ${theCard.currentPower} joined the battlefield")
  }

  /** A function that puts a WeatherCard in Weather on the Board.
   * 
   * @param theCard The Card to be put.
   */
  def putCardWR(theCard: WeatherCard): Unit = {
    board.assignWeather(theCard)
  }
  
  /** A functions that clears all rows on the BoardSection.
   */
  def clearBoardSection: Unit = {
    for (card <- CloseCombatRow){
      Graveyard :+ card
    }
    CloseCombatRow = ListBuffer[CloseCombatUnit]()
    for (card <- RangedCombatRow){
      Graveyard :+ card
    }
    RangedCombatRow = ListBuffer[RangedCombatUnit]()
    for (card <- SiegeCombatRow){
      Graveyard :+ card
    }
    SiegeCombatRow = ListBuffer[SiegeCombatUnit]()
    updateTotalPower
  }
  
  
  //Show rows ----------------------------------------

  /** Print the cards in the CloseCombatRow.
   */
  def showCloseCombatRow(): Unit = {
    for (card <- CloseCombatRow) {
      println(s"Name: ${card.getName}, Power: ${card.currentPower}")
    }
  }

  /** Print the cards in the RangedCombatRow.
   */
  def showRangedCombatRow(): Unit = {
    for (card <- RangedCombatRow) {
      println(s"Name: ${card.getName}, Power: ${card.currentPower}")
    }
  }

  /** Print the cards in the SiegeCombatRow.
   */
  def showSiegeCombatRow(): Unit = {
    for (card <- SiegeCombatRow) {
      println(s"Name: ${card.getName}, Power: ${card.currentPower}")
    }
  }

}
