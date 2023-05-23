package cl.uchile.dcc
package gwent.players

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends FunSuite {
  val name = "player1"
  var player1: HumanPlayer = _
  var cpu: CpuPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new HumanPlayer(name, ListBuffer())
    cpu = new CpuPlayer(ListBuffer())
  }

  test("A HumanPlayer needs a name and a deck, the deck starts empty"){
    assertEquals(player1.getUsername, name)
    assertEquals(player1.theDeck.isEmpty, true)
  }
  test("A CpuPlayer already has a name") {
    assertEquals(cpu.getUsername, "CPU")
  }
  test("Each player start with 2 gems") {
    assertEquals(player1.getGems, 2)
    assertEquals(cpu.getGems, 2)
  }
  test("When a player lost the round, lost a gem and gets defeated when it lost 2") {
    cpu.roundLost
    assertEquals(cpu.getGems, 1)
    cpu.roundLost
    assertEquals(cpu.isDefeated, true)
  }


}
