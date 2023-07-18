package cl.uchile.dcc
package gwent.states

import gwent.GameController

import gwent.exceptions.InvalidTransitionException

class GameState(context: GameController){
  
  context.gameState = this

  /** A function that throws an InvalidTransitionException.
   *
   * @param targetState The GameState you try to transition.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"Cannot transition to $targetState")
  }

  /** A function that varies on each State.
   */
  def action(): Unit = {
    println("I think I should do something")
  }
  
  //Transition functions --------------------------------------------------

  /** A function that switch the gameState to BeforeMatchState.
   */
  def toBeforeMatchState(): Unit = {
    transitionError("BeforeMatchState")
  }

  /** A function that switch the gameState to RoundStudyState.
   */
  def toBeginRoundState(): Unit = {
    transitionError("BeginRoundState")
  }

  /** A function that switch the gameState to InTurnState.
   */
  def toInTurnState(): Unit = {
    transitionError("InTurnState")
  }

  /** A function that switch the gameState to WaitingTurnState.
   */
  def toWaitingTurnState(): Unit = {
    transitionError("WaitingTurnState")
  }

  /** A function that switch the gameState to StandByState.
   */
  def toStandByState(): Unit = {
    transitionError("StandByState")
  }
  
  def toEndRoundState(): Unit = {
    transitionError("EndRoundState")
  }

  /** A function that switch the gameState to AfterMatchState.
   */
  def toAfterMatchState(): Unit = {
    transitionError("AfterMatchState")
  }

}
