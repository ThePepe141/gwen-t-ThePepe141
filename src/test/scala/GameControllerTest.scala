package cl.uchile.dcc
import gwent.GameController
import gwent.exceptions.InvalidTransitionException
import gwent.cards.Card
import gwent.cards.units.{BlueStripesCommando, CrinfridReaversHunter, RedanianArcher, TemerianInfantry}
import gwent.board.Board
import gwent.players.{CpuPlayer, HumanPlayer, Player}
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
    for (_ <- 1 to 25){
      deck1 = deck1 :+ new TemerianInfantry
      deck2 = deck2 :+ new RedanianArcher
    }

  }

  test("Tests for methods"){
    //Testing the matchSettings
    gameCon.matchSettings("Pepe", deck1, deck2)
    assertEquals(gameCon.humanPlayer.getUsername, "Pepe")
    assertEquals(gameCon.humanPlayer.getDeck, deck1)
    assertEquals(gameCon.cpuPlayer.getDeck, deck2)
    assertEquals(gameCon.theBoard.players, ListBuffer[Player](gameCon.humanPlayer, gameCon.cpuPlayer))
    //Transition to BeginRoundState
    //Testing the roundSettings
    gameCon.roundSettings()
    assert(gameCon.gameState.isInstanceOf[InTurnState] || gameCon.gameState.isInstanceOf[WaitingTurnState])
    //We force the InTurnState and test humanMove()
    gameCon.gameState = new InTurnState(gameCon)
    gameCon.humanMove(1,0)
    assertEquals(gameCon.theBoard.Front.getCCRpower, 5)
    //Transition to WaitingTurnState
    //Testing the machineMove()
    gameCon.machineMove(0)
    assertEquals(gameCon.theBoard.Back.getRCRpower, 3)
    //Transition to InTurnState
    //Defining the machineCardChoice
    gameCon.machineCardChoice = 0
    //Testing (implicitly) humanPass(), machinePass and endingRound()
    gameCon.humanMove(2,0)
    //Transition to StandByState
    //Testing humanPass, endingRound and machinePass (implicitly)
    gameCon.humanPass()
    gameCon.endingRound()
    //Transition to EndRoundState
    //Testing notifyPlayers (and updateLost and updateGems implicitly)
    gameCon.notifyPlayers()
    gameCon.roundUpdate()
    //The match is not over, transition to BeginRoundState
    gameCon.roundSettings()
    //We force (again) InTurnState we test for a draw case and a match lost.
    gameCon.gameState = new InTurnState(gameCon)
    gameCon.humanMove(1,0)
    gameCon.machineMove(0)
    gameCon.humanMove(1,0)
    gameCon.machineMove(0)
    gameCon.humanMove(1,0)
    gameCon.machineMove(0)
    gameCon.humanMove(1, 0)
    gameCon.machineMove(0)
    gameCon.humanMove(1, 0)
    gameCon.machineMove(0)
    gameCon.humanMove(1, 0)
    gameCon.machineMove(0)
    gameCon.humanMove(2,0)
    gameCon.humanPass()
    gameCon.endingRound()
    gameCon.notifyPlayers()
    gameCon.roundUpdate()
    //Human Player lost the match
    assert(gameCon.gameState.isInstanceOf[AfterMatchState])
    //Testing postMatch
    gameCon.postMatch()
    assertEquals(gameCon.theBoard.FrontPoints, ListBuffer[Int](5,30))
    assertEquals(gameCon.theBoard.BackPoints, ListBuffer[Int](6,30))
  }

  test("You can print the deck and hand of the human player along with the board"){
    gameCon.matchSettings("Pepe", deck1, deck2)
    gameCon.roundSettings()
    gameCon.showDeck()
    gameCon.showHand()
    gameCon.showBoard()
  }






}
