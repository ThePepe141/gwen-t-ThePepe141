package cl.uchile.dcc
package gwent.states

import gwent.GameController

class BeforeMatchState(context: GameController) extends GameState(context){

  override def action(): Unit = {
    context.matchSettings()
  }

  override def toBeginRoundState(): Unit = {
    context.gameState = new BeginRoundState(context) 
  }

}
