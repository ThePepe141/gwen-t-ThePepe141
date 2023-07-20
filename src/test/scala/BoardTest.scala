package cl.uchile.dcc
import gwent.board.Board
import gwent.cards.Card
import gwent.players.{CpuPlayer, HumanPlayer}

import cl.uchile.dcc.gwent.cards.units.{RedanianArcher, ReinforcedTrebuchet, TemerianInfantry}
import cl.uchile.dcc.gwent.cards.weathers.SunnyDay
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
    for (a <- 1 to 9) {
      val carta1 = new TemerianInfantry
      val carta2 = new RedanianArcher
      val carta3 = new ReinforcedTrebuchet
      player1.addToDeck(carta1)
      player1.addToDeck(carta2)
      player1.addToDeck(carta3)
      player2.addToDeck(carta1)
      player2.addToDeck(carta2)
      player2.addToDeck(carta3)
    }

  }

  test("The Board automatically assign BoardSections to the Players") {
    //Test for getBoardSection and Board class in general
    assertEquals(player1.getBoardSection, theBoard.Front)
    assertEquals(player2.getBoardSection, theBoard.Back)
  }

  test("To initiate a Match each Player needs (at least) 25 Cards on their decks") {
    //Test for startMatch
    theBoard.startMatch
  }
  test("When a Round beings each Player draw a number of Cards"){
    //Test for startRound and handOutCards
    theBoard.startMatch
    assert(player1.getHand.isEmpty)
    assert(player2.getHand.isEmpty)
    theBoard.startRound
    assertEquals(player1.getHand.length, 10)
    assertEquals(player2.getHand.length, 10)
  }

  test("You can fill de rows"){
    
  }

  test("The power on each row can change"){
    //Test for get and update functions of each row
    assertEquals(theBoard.Front.getCCRpower, 0)
    theBoard.Front.putCardCCR(new TemerianInfantry)
    assertEquals(theBoard.Front.getCCRpower, 5)
    assertEquals(theBoard.Front.getRCRpower, 0)
    theBoard.Front.putCardRCR(new RedanianArcher)
    assertEquals(theBoard.Front.getRCRpower, 3)
    assertEquals(theBoard.Front.getSCRpower, 0)
    theBoard.Front.putCardSCR(new ReinforcedTrebuchet)
    assertEquals(theBoard.Front.getSCRpower, 6)
    assertEquals(theBoard.Front.getTotalPower, 14)
    theBoard.clearBoard
    assertEquals(theBoard.Front.getTotalPower, 0)
  }
  

}
