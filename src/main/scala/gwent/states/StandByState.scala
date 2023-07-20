package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** A class that represents the GameState of having pass the Round.
 * 
 * @param context The GameController associated.
 */
class StandByState(context: GameController) extends GameState(context) {

  /** Trigger the GameController functions for when the player pass the round.
   */
  override def action(): Unit = {
    context.humanPass()
    context.endingRound()
  }

  override def toEndRoundState(): Unit = {
    context.gameState = new EndRoundState(context)
    context.trigger()
  }

}
