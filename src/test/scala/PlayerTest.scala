import cl.uchile.dcc.gwent.cards.UnitCard
import cl.uchile.dcc.gwent.players.{CpuPlayer, HumanPlayer}
import cl.uchile.dcc.gwent.cards.units.{RedanianArcher, ReinforcedTrebuchet, TemerianInfantry}
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends FunSuite {
  val name = "player1"
  var player1: HumanPlayer = _
  var cpu: CpuPlayer = _
  var soldier1: UnitCard = _
  var archer1: UnitCard = _
  var engine1: UnitCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new HumanPlayer(name, ListBuffer())
    cpu = new CpuPlayer(ListBuffer())
    soldier1 = new TemerianInfantry()
    archer1 = new RedanianArcher()
    engine1 = new ReinforcedTrebuchet()

  }

  test("A HumanPlayer needs a name and a deck, the deck starts empty"){
    //Test for getUsername
    assertEquals(player1.getUsername, name)
    assertEquals(player1.theDeck.isEmpty, true)
  }
  test("A CpuPlayer already has a name, the deck starts empty") {
    assertEquals(cpu.getUsername, "CPU")
    assertEquals(cpu.theDeck.isEmpty, true)
  }
  test("Each player start with 2 gems") {
    //Test for getGems
    assertEquals(player1.getGems, 2)
    assertEquals(cpu.getGems, 2)
  }
  test("When a player lost the round, lost a gem and gets defeated when it lost 2") {
    //Test for roundLost and isDefeated
    cpu.roundLost
    assertEquals(cpu.getGems, 1)
    cpu.roundLost
    assertEquals(cpu.isDefeated, true)
  }

  test("A deck can be filled") {
    //Test for addToDeck and deckSize
    val fisrtSize = player1.deckSize
    player1.addToDeck(soldier1)
    player1.addToDeck(archer1)
    player1.addToDeck(engine1)
    val endSize = player1.deckSize
    assertEquals(fisrtSize, 0)
    assertEquals(endSize, 3)
  }

  test("A deck can be shuffle") {
    //Test for shuffleDeck
    player1.addToDeck(soldier1)
    player1.addToDeck(archer1)
    player1.addToDeck(engine1)
    val originalDeck = player1.getDeck
    val originalSize = player1.deckSize
    val shuffleDeck = player1.shuffleDeck
    val endSize = player1.deckSize
    println(originalDeck)
    println(shuffleDeck)
    assertEquals(originalSize, endSize)
  }

  test("A player can draw a Card from the deck to his hand") {
    //Test for drawCard
    player1.addToDeck(soldier1)
    player1.addToDeck(archer1)
    player1.addToDeck(engine1)
    player1.drawCard
    val endSize = player1.deckSize
    assertEquals(endSize, 2)
    assertEquals(player1.getHand.head, soldier1)
  }


}
