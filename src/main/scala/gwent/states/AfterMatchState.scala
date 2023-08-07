package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** A class that represents the GameState of after the Match has ended.
 * 
 * @param context The GameController associated.
 */
class AfterMatchState(context: GameController) extends GameState(context){

  /** Trigger the GameController function for when the match ends.
   */
  override def action(): Unit = {
    context.postMatch()
  }

  override def toBeforeMatchState(): Unit = {
    context.gameState = new BeforeMatchState(context)
    context.trigger()
  }

}
