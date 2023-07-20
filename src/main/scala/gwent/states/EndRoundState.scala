package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** A class that represents the GameState of after the round ends, when both players have passed.
 *
 * @param context The GameController associated.
 */
class EndRoundState(context: GameController) extends GameState(context) {

  /** Trigger the GameController function for when the round ends.
   */
  override def action(): Unit = {
    context.definingWinner()
  }

  override def toBeginRoundState(): Unit = {
    context.gameState = new BeginRoundState(context)
    context.trigger()
  }
  
  override def toAfterMatchState(): Unit = {
    context.gameState = new AfterMatchState(context)
    context.trigger()
  }

}
