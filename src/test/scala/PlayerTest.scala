package cl.uchile.dcc
package gwent.players

import munit.FunSuite

class PlayerTest extends FunSuite {
  val name = "player1"
  var player1: HumanPlayer = _
  var cpu: CpuPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new HumanPlayer(name, List())
    cpu = new CpuPlayer(List())
  }
  test("A HumanPlayer needs a name and a deck"){
    assertEquals(player1.username, name)
  }
  test("A CpuPlayer only needs a deck") {
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
    assert(cpu.isDefeated)
  }
}
