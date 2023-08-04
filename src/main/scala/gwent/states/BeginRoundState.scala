package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** A class that represents the GameState of before the Round has started.
 * 
 * @param context The GameController associated.
 */
class BeginRoundState(context: GameController) extends GameState(context) {

  /** Trigger the GameController function that goes before the Round.
   */
  override def action(): Unit = {
    context.roundSettings()
  }

  override def toInTurnState(): Unit = {
    context.gameState = new InTurnState(context)
  }

  override def toWaitingTurnState(): Unit = {
    context.gameState = new WaitingTurnState(context)
  }

}
