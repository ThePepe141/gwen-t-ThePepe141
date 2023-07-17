package cl.uchile.dcc
package gwent

import gwent.board.Board

import cl.uchile.dcc.gwent.players.{CpuPlayer, HumanPlayer}
import cl.uchile.dcc.gwent.states.GameState

class GameController {

  /** The current state of the game
   */
  var gameState: GameState = _
  
  var humanPlayer: HumanPlayer = _
  var cpuPlayer: CpuPlayer = _
  var board: Board = _

}
