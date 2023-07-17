package cl.uchile.dcc
package gwent.states

import gwent.GameController

import cl.uchile.dcc.gwent.exceptions.InvalidTransitionException

class GameState(val context: GameController) {

  context.gameState = this

  /** A function that throws an InvalidTransitionException.
   *
   * @param targetState The GameState you wanted to transition.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"Cannot transition to $targetState")
  }

  //Transitions functions ------------------------------------------------------

  /** A function that change the GameState to BeforeMatchState.
   */
  def toBeforeMatchState: Unit = {
    transitionError("BeforeMatchState")
  }
  
  /** A function that change the GameState to InMatchState.
   */
  def toInMatchState: Unit = {
    transitionError("InMatchState")
  }

  /** A function that change the MatchState to InTurnState.
   */
  def toInTurnState: Unit = {
    transitionError("InTurnState")
  }

  /** A function that change the MatchState to WaitingTurnState.
   */
  def toWaitingTurnState: Unit = {
    transitionError("WaitingTurnState")
  }

  /** A function that change the MatchState to StandByState.
   */
  def toStandByState: Unit = {
    transitionError("StandByState")
  }

  /** A function that change the GameState to AfterMatchState.
   */
  def toAfterMatchState: Unit = {
    transitionError("AfterMatchState")
  }
  //-------------------------------------------------------------

}
