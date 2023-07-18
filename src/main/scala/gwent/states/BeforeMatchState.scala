package cl.uchile.dcc
package gwent.states

import gwent.GameController

import cl.uchile.dcc.gwent.board.Board

class BeforeMatchState(context: GameController) extends GameState(context){

  override def action: Unit = {
    context.buildDecks
  }

  override def toInTurnState: Unit = {
    context.board.assignSections
    context.board.startMatch
    context.board.startRound
    context.gameState = new InTurnState(context)
    context.beginRound
  }


  override def toWaitingTurnState: Unit = {
    context.board.assignSections
    context.board.startMatch
    context.board.startRound
    context.gameState = new WaitingTurnState(context)
    context.beginRound
  }
  
}
