package cl.uchile.dcc
package gwent.states

import gwent.GameController

/** A class that represents the GameState of before the match has started.
 * 
 * @param context The GameController associated.
 */
class BeforeMatchState(context: GameController) extends GameState(context){

  /** Trigger the GameController functions that goes before the match.
   */
  override def action(): Unit = {
    context.matchSettings(context.humanName, context.humanDeck, context.cpuDeck)
  }

  override def toBeginRoundState(): Unit = {
    context.gameState = new BeginRoundState(context)
  }

}
