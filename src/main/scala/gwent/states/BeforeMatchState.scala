package cl.uchile.dcc
package gwent.states

import gwent.GameController

import cl.uchile.dcc.gwent.board.Board

class BeforeMatchState(context: GameController) extends GameState(context){

  override def toInMatchState: Unit = {
    context.gameState = new InMatchState(context)
  }
}
