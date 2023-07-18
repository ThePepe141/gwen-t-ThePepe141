package cl.uchile.dcc
package gwent.states

import gwent.GameController

class BeforeMatchState(context: GameController) extends GameState(context){

  override def action(): Unit = {
    context.setPlayers()
    if (!context.keepDecks){
      context.matchSettings()
    }
    context.setBoard()
  }

  override def toBeginRoundState(): Unit = {
    context.gameState = new BeginRoundState(context)
    context.trigger()
  }

}
