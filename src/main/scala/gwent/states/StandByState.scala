package cl.uchile.dcc
package gwent.states

import gwent.GameController

class StandByState(context: GameController) extends GameState(context) {

  override def toAfterMatchState: Unit = {
    context.gameState = new AfterMatchState(context)
  }
}
