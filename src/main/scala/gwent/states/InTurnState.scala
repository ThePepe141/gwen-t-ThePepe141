package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** A class that represents the GameState of humanPlayer´s turn.
 * 
 * @param context The GameController associated.
 */
class InTurnState(context: GameController) extends GameState(context) {

  /** Trigger the GameController function that represents the player´s turn.
   */
  override def action(): Unit = {
    context.humanMove(context.humanChoice, context.humanCardChoice)
  }

  override def toWaitingTurnState(): Unit = {
    context.gameState = new WaitingTurnState(context)
    println(s"Opponent turn.")
    //context.trigger()
  }

  override def toStandByState(): Unit = {
    context.gameState = new StandByState(context)
    //context.trigger()
  }

}
