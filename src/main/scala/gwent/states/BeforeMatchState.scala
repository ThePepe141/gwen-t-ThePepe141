package cl.uchile.dcc
package gwent.states

import gwent.GameController

class BeforeMatchState(context: GameController) extends GameState(context){

  override def toInMatchState: Unit = {
    context.gameState = new InMatchState(context)
  }
}
