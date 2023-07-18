package cl.uchile.dcc
package gwent.states

import gwent.GameController

class AfterMatchState(context: GameController) extends GameState(context){

  override def toBeforeMatchState(): Unit = {
    context.gameState = new BeforeMatchState(context)
  }

}
