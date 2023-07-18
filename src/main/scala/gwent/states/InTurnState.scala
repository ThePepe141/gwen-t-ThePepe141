package cl.uchile.dcc
package gwent.states

import gwent.GameController

class InTurnState(context: GameController) extends GameState(context) {

  override def action: Unit = {
    context.makeChoice
  }

  override def toWaitingTurnState: Unit = {
    context.gameState = new WaitingTurnState(context)
  }

  override def toStandByState: Unit = {
    context.gameState = new StandByState(context)
  }
}
