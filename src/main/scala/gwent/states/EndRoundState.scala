package cl.uchile.dcc
package gwent.states

import gwent.GameController

class EndRoundState(context: GameController) extends GameState(context) {

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
