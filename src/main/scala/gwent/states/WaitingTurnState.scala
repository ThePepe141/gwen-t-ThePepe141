package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** A class that represents the GameState of the cpu player´s turn.
 * 
 * @param context The GameController associated.
 */
class WaitingTurnState(context: GameController) extends GameState(context) {

  /** Trigger the GameController function that represents cpu player´s turn..
   */
  override def action(): Unit = {
    context.machineMove()
  }

  override def toInTurnState(): Unit = {
    context.gameState = new InTurnState(context)
  }

}
