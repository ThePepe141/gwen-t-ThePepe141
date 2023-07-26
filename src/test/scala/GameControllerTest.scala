package cl.uchile.dcc
import gwent.GameController

import cl.uchile.dcc.gwent.exceptions.InvalidTransitionException
import cl.uchile.dcc.gwent.states.{AfterMatchState, BeforeMatchState, BeginRoundState, EndRoundState, GameState, InTurnState, StandByState, WaitingTurnState}
import munit.FunSuite
class GameControllerTest extends FunSuite{

  var gameCon: GameController = _
  var state1: GameState = _
  var state2: GameState = _
  var state3: GameState = _
  var state4: GameState = _
  var state5: GameState = _
  var state6: GameState = _
  var state7: GameState = _

  override def beforeEach(context: BeforeEach): Unit = {
    gameCon = new GameController
    state1 = new BeforeMatchState(new GameController)
    state2 = new BeginRoundState(new GameController)
    state3 = new InTurnState(new GameController)
    state4 = new WaitingTurnState(new GameController)
    state5 = new StandByState(new GameController)
    state6 = new EndRoundState(new GameController)
    state7 = new AfterMatchState(new GameController)
  }

  test("A GameController starts in BeforeMatchState"){
    assertEquals(gameCon.gameState.getClass, state1.getClass)
  }

  test("A BeforeMatchState can only transit to BeginRoundState"){
    try{
      state1.toBeforeMatchState()
    }catch {
      case e: InvalidTransitionException => println("It cant")
    }
    try {
      state1.toInTurnState()
    } catch {
      case e: InvalidTransitionException => println("It cant")
    }
    try {
      state1.toAfterMatchState()
    } catch {
      case e: InvalidTransitionException => println("It cant")
    }
    try {
      state1.toWaitingTurnState()
    } catch {
      case e: InvalidTransitionException => println("It cant")
    }
    try {
      state1.toEndRoundState()
    } catch {
      case e: InvalidTransitionException => println("It cant")
    }
    try {
      state1.toStandByState()
    } catch {
      case e: InvalidTransitionException => println("It cant")
    }
    state1.toBeginRoundState()
    assertEquals(state1.getClass, state2.getClass)


  }


}
