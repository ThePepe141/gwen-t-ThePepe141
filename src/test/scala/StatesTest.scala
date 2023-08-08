package cl.uchile.dcc

import gwent.GameController

import gwent.exceptions.InvalidTransitionException
import gwent.states.{AfterMatchState, BeforeMatchState, BeginRoundState, EndRoundState, InTurnState, StandByState, WaitingTurnState}
import munit.FunSuite

class StatesTest extends FunSuite {

  var gameCon: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    gameCon = new GameController
  }

  test("BeforeMatchState can only translate to BeginRoundState"){
    println("BeforeMatchState..")
    try{
      gameCon.gameState.toBeforeMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to BeforeMatchState")
    }
    try{
      gameCon.gameState.toInTurnState()
    } catch{
      case _: InvalidTransitionException => println("Cannot transition to InTurnState")
    }
    try{
      gameCon.gameState.toWaitingTurnState()
    } catch{
      case _: InvalidTransitionException => println("Cannot transition to WaitingTurnState")
    }
    try{
      gameCon.gameState.toStandByState()
    } catch{
      case _: InvalidTransitionException => println("Cannot transition to StandByState")
    }
    try{
      gameCon.gameState.toEndRoundState()
    } catch{
      case _: InvalidTransitionException => println("Cannot transition to EndRoundState")
    }
    try{
      gameCon.gameState.toAfterMatchState()
    } catch{
      case _: InvalidTransitionException => println("Cannot transition to AfterMatchState")
    } finally {
      gameCon.gameState.toBeginRoundState()
      assert(gameCon.gameState.isInstanceOf[BeginRoundState])
    }
  }

  test("BeginRoundState can only transition to either InTurnState or WaitingTurnState"){
    gameCon.gameState = new BeginRoundState(gameCon)
    println("BeginRoundState...")
    try {
      gameCon.gameState.toBeforeMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to BeforeMatchState")
    }
    try {
      gameCon.gameState.toBeginRoundState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to BeginRoundState")
    }
    try {
      gameCon.gameState.toStandByState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to StandByState")
    }
    try {
      gameCon.gameState.toEndRoundState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to EndRoundState")
    }
    try {
      gameCon.gameState.toAfterMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to AfterMatchState")
    } finally {
      gameCon.gameState.toInTurnState()
      assert(gameCon.gameState.isInstanceOf[InTurnState])
    }
    gameCon.gameState = new BeginRoundState(gameCon)
    gameCon.gameState.toWaitingTurnState()
    assert(gameCon.gameState.isInstanceOf[WaitingTurnState])
  }

  test("InTurnState can only transition to either WaitingTurnState or StandByState"){
    gameCon.gameState = new InTurnState(gameCon)
    println("InTurnState...")
    try {
      gameCon.gameState.toBeforeMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to BeforeMatchState")
    }
    try{
      gameCon.gameState.toBeginRoundState()
    } catch{
      case _: InvalidTransitionException => println("Cannot transition to BeginRoundState")
    }
    try {
      gameCon.gameState.toInTurnState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to InTurnState")
    }
    try {
      gameCon.gameState.toEndRoundState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to EndRoundState")
    }
    try {
      gameCon.gameState.toAfterMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to AfterMatchState")
    } finally {
      gameCon.gameState.toWaitingTurnState()
      assert(gameCon.gameState.isInstanceOf[WaitingTurnState])
    }
    gameCon.gameState = new InTurnState(gameCon)
    gameCon.gameState.toStandByState()
    assert(gameCon.gameState.isInstanceOf[StandByState])
  }

  test("WaitingTurnState can only transition to InTurnState"){
    gameCon.gameState = new WaitingTurnState(gameCon)
    println("WaitingTurnState...")
    try {
      gameCon.gameState.toBeforeMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to BeforeMatchState")
    }
    try {
      gameCon.gameState.toBeginRoundState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to BeginRoundState")
    }
    try {
      gameCon.gameState.toWaitingTurnState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to WaitingTurnState")
    }
    try {
      gameCon.gameState.toStandByState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to StandByState")
    }
    try {
      gameCon.gameState.toEndRoundState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to EndRoundState")
    }
    try {
      gameCon.gameState.toAfterMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to AfterMatchState")
    } finally {
      gameCon.gameState.toInTurnState()
      assert(gameCon.gameState.isInstanceOf[InTurnState])
    }
  }

  test("StandByState can only transition to EndRoundState"){
    gameCon.gameState = new StandByState(gameCon)
    println("StandbyState...")
    try {
      gameCon.gameState.toBeforeMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to BeforeMatchState")
    }
    try{
      gameCon.gameState.toBeginRoundState()
    } catch{
      case _: InvalidTransitionException => println("Cannot transition to BeginRoundState")
    }
    try {
      gameCon.gameState.toInTurnState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to InTurnState")
    }
    try {
      gameCon.gameState.toWaitingTurnState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to WaitingTurnState")
    }
    try {
      gameCon.gameState.toStandByState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to StandByState")
    }
    try {
      gameCon.gameState.toAfterMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to AfterMatchState")
    } finally {
      gameCon.gameState.toEndRoundState()
      assert(gameCon.gameState.isInstanceOf[EndRoundState])
    }
  }

  test("EndRoundState can only transition to either BeginRoundState or AfterMatchState"){
    gameCon.gameState = new EndRoundState(gameCon)
    println("EndRoundState...")
    try {
      gameCon.gameState.toBeforeMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to BeforeMatchState")
    }
    try {
      gameCon.gameState.toInTurnState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to InTurnState")
    }
    try {
      gameCon.gameState.toWaitingTurnState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to WaitingTurnState")
    }
    try {
      gameCon.gameState.toStandByState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to StandByState")
    }
    try {
      gameCon.gameState.toEndRoundState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to EndRoundState")
    } finally {
      gameCon.gameState.toBeginRoundState()
      assert(gameCon.gameState.isInstanceOf[BeginRoundState])
    }
    gameCon.gameState = new EndRoundState(gameCon)
    gameCon.gameState.toAfterMatchState()
    assert(gameCon.gameState.isInstanceOf[AfterMatchState])
  }
  
  test("AfterMatchState can only transition to BeforeKMatchState"){
    gameCon.gameState = new AfterMatchState(gameCon)
    println("AfterMatchState...")
    try{
      gameCon.gameState.toBeginRoundState()
    } catch{
      case _: InvalidTransitionException => println("Cannot transition to BeginRoundState")
    }
    try {
      gameCon.gameState.toInTurnState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to InTurnState")
    }
    try {
      gameCon.gameState.toWaitingTurnState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to WaitingTurnState")
    }
    try {
      gameCon.gameState.toStandByState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to StandByState")
    }
    try {
      gameCon.gameState.toEndRoundState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to EndRoundState")
    }
    try {
      gameCon.gameState.toAfterMatchState()
    } catch {
      case _: InvalidTransitionException => println("Cannot transition to AfterMatchState")
    } finally {
      gameCon.gameState.toBeforeMatchState()
      assert(gameCon.gameState.isInstanceOf[BeforeMatchState])
    }
  }

}
