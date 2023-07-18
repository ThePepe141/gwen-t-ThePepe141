package cl.uchile.dcc
package gwent.states

import gwent.GameController

class WaitingTurnState(context: GameController) extends GameState(context){

  override def action: Unit = {
    context.opponentMove
  }
  override def toInTurnState: Unit = {
    context.gameState = new InTurnState(context)
    context.gameState.action
  }

  override def toAfterMatchState: Unit = {
    context.gameState = new AfterMatchState(context)
  }
}
