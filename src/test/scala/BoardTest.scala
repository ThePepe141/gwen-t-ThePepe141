package cl.uchile.dcc
import gwent.board.Board
import gwent.cards.Card
import gwent.players.{CpuPlayer, HumanPlayer}
import munit.FunSuite

import scala.collection.mutable.ListBuffer


class BoardTest extends FunSuite {

  var theBoard: Board = _
  var player1: HumanPlayer = _
  var player2: CpuPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new HumanPlayer("Pepe", ListBuffer[Card]())
    player2 = new CpuPlayer(ListBuffer[Card]())
    theBoard = new Board(player1, player2)

  }

  test("The Board automatically assign BoardSections to the Players") {
    //Test for getBoardSection and Board class in general
    assertEquals(player1.getBoardSection, theBoard.Front)
    assertEquals(player2.getBoardSection, theBoard.Back)
  }

}
