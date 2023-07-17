package cl.uchile.dcc
package gwent

import gwent.board.Board

import cl.uchile.dcc.gwent.players.{CpuPlayer, HumanPlayer}
import cl.uchile.dcc.gwent.states.{GameState, MatchState}

class GameController {

  /** The current state of the game
   */
  var gameState: GameState = _
  
  /** The current state of the match
   */
  var matchState: MatchState = _

  private var board: Board = _
  private var humanPlayer: HumanPlayer = _
  private var cpuPlayer: CpuPlayer = _

}
