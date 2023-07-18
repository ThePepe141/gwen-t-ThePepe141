package cl.uchile.dcc
package gwent.states

import gwent.GameController

class BeginRoundState(context: GameController) extends GameState(context) {

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
