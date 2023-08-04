package cl.uchile.dcc
import gwent.GameController
import gwent.exceptions.InvalidTransitionException
import gwent.cards.Card
import gwent.cards.units.{RedanianArcher, TemerianInfantry}
import gwent.board.Board
import gwent.players.{Player, CpuPlayer, HumanPlayer}
import gwent.states.{AfterMatchState, BeforeMatchState, BeginRoundState, EndRoundState, GameState, InTurnState, StandByState, WaitingTurnState}

import munit.FunSuite

import scala.collection.mutable.ListBuffer
class GameControllerTest extends FunSuite{

  var gameCon: GameController = _
  var deck1: ListBuffer[Card] = _
  var deck2: ListBuffer[Card] = _
  override def beforeEach(context: BeforeEach): Unit = {
    gameCon = new GameController
    deck1 = ListBuffer[Card]()
    deck2 = ListBuffer[Card]()
    for (a <- 1 to 25){
      deck1 = deck1 :+ new TemerianInfantry
      deck2 = deck2 :+ new RedanianArcher
    }

  }

  test("Tests for methods"){
    gameCon.matchSettings("Pepe", deck1, deck2)
    assertEquals(gameCon.humanPlayer.getUsername, "Pepe")
    assertEquals(gameCon.humanPlayer.getDeck, deck1)
    assertEquals(gameCon.cpuPlayer.getDeck, deck2)
    assertEquals(gameCon.theBoard.players, ListBuffer[Player](gameCon.humanPlayer, gameCon.cpuPlayer))
  }




}
