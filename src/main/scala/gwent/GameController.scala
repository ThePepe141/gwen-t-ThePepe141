package cl.uchile.dcc
package gwent

import gwent.board.Board

import cl.uchile.dcc.gwent.cards.Card

import scala.io.StdIn.readLine
import cl.uchile.dcc.gwent.players.{CpuPlayer, HumanPlayer}
import cl.uchile.dcc.gwent.states.{BeforeMatchState, GameState}

import scala.collection.mutable.ListBuffer

class GameController {

  /** The current state of the game
   */
  var gameState: GameState = new BeforeMatchState(this)
  
  var humanPlayer: HumanPlayer = _
  var cpuPlayer: CpuPlayer = _
  var board: Board = _

  def startMatch: Unit = {
    println("Hello Human player, please choose your name")
    val name = readLine()
    humanPlayer = new HumanPlayer(name, ListBuffer[Card]())
    println("Thank you")
    println("Now choose your deck")

  }

}
