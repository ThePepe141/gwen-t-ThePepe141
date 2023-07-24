package cl.uchile.dcc
import gwent.board.Board
import gwent.cards.Card
import gwent.players.{CpuPlayer, HumanPlayer}

import cl.uchile.dcc.gwent.cards.units.{BlueStripesCommando, RedanianArcher, ReinforcedTrebuchet, TemerianInfantry}
import gwent.cards.units.{Catapult, CrinfridReaversHunter, Dandelion, KaedweniSiegeExpert}

import cl.uchile.dcc.gwent.cards.weathers.{BitingFrost, ImpenetrableFog, SunnyDay, TorrentialRain}
import munit.FunSuite

import scala.collection.mutable.ListBuffer


class BoardTest extends FunSuite {

  var theBoard: Board = _
  var player1: HumanPlayer = _
  var player2: CpuPlayer = _
  var commando1: BlueStripesCommando = _
  var catapult1: Catapult = _
  var hunter1: CrinfridReaversHunter = _
  var bard1: Dandelion = _
  var expert1: KaedweniSiegeExpert = _

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
    commando1 = new BlueStripesCommando
    catapult1 = new Catapult
    hunter1 = new CrinfridReaversHunter
    bard1 = new Dandelion
    expert1 = new KaedweniSiegeExpert

  }

  test("The Board automatically assign BoardSections to the Players") {
    //Test for assignSections, getBoardSection and Board class in general
    theBoard.assignSections
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
    assert(theBoard.Front.getCloseCombatRow.isEmpty)
    theBoard.Front.putCardCCR(new TemerianInfantry)
    assert(theBoard.Front.getCloseCombatRow.nonEmpty)
    assert(theBoard.Front.getRangedCombatRow.isEmpty)
    theBoard.Front.putCardRCR(new RedanianArcher)
    assert(theBoard.Front.getRangedCombatRow.nonEmpty)
    assert(theBoard.Front.getSiegeCombatRow.isEmpty)
    theBoard.Front.putCardSCR(new ReinforcedTrebuchet)
    assert(theBoard.Front.getSiegeCombatRow.nonEmpty)
  }

  test("The power on each row can change"){
    //Test for get and update functions of each row, assignPoints, clearBoard
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
    theBoard.startRound
    theBoard.assignPoints
    assertEquals(theBoard.FrontPoints.head, 14)
    theBoard.clearBoard
    assertEquals(theBoard.Front.getTotalPower, 0)
  }

  test("Test for MoraleBoost"){
    theBoard.Front.putCardCCR(new TemerianInfantry)
    theBoard.Front.putCardCCR(new TemerianInfantry)
    theBoard.Front.putCardCCR(new Dandelion)
    assertEquals(theBoard.Front.getCCRpower, 14)
  }

  test("Test for StrongBond") {
    theBoard.Front.putCardCCR(new BlueStripesCommando)
    theBoard.Front.putCardCCR(new TemerianInfantry)
    theBoard.Front.putCardCCR(new BlueStripesCommando)
    assertEquals(theBoard.Front.getCCRpower, 21)

  }

  test("Test for effects"){
    //Biting Frost
    theBoard.Front.putCardCCR(new TemerianInfantry)
    theBoard.Front.putCardCCR(new TemerianInfantry)
    theBoard.Front.putCardWR(new BitingFrost)
    assertEquals(theBoard.Front.getCCRpower, 2)
    //Impenetrable Fog
    theBoard.Front.putCardRCR(new RedanianArcher)
    theBoard.Front.putCardRCR(new RedanianArcher)
    theBoard.Front.putCardWR(new ImpenetrableFog)
    assertEquals(theBoard.Front.getRCRpower, 2)
    //Torrential Rain
    theBoard.Front.putCardSCR(new ReinforcedTrebuchet)
    theBoard.Front.putCardSCR(new ReinforcedTrebuchet)
    theBoard.Front.putCardWR(new TorrentialRain)
    assertEquals(theBoard.Front.getSCRpower, 2)
  }
  

}
