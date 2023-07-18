package cl.uchile.dcc
package gwent.states

import gwent.GameController

class InTurnState(context: GameController) extends GameState(context) {

  override def action(): Unit = {
    context.humanMove()
  }

  override def toWaitingTurnState(): Unit = {
    context.gameState = new WaitingTurnState(context)
    context.trigger()
  }

  override def toStandByState(): Unit = {
    context.gameState = new StandByState(context)
    context.trigger()
  }

}
