package cl.uchile.dcc
package gwent.states

import gwent.GameController

class StandByState(context: GameController) extends GameState(context) {

  override def action(): Unit = {
    context.humanPass()
    context.endingRound()
  }

  override def toEndRoundState(): Unit = {
    context.gameState = new EndRoundState(context)
    context.trigger()
  }

}
