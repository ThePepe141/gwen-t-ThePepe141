package cl.uchile.dcc
package gwent.players

import munit.FunSuite

class PlayerTest extends FunSuite {
  val name = "player1"
  var player1: HumanPlayer = _
  var cpu: CpuPlayer = _

  override def beforeEach(context: BeforeEach): Unit = {
    player1 = new HumanPlayer(name)
    cpu = new CpuPlayer()
  }
  test("A HumanPlayer can be created with only a username"){
    assertEquals(player1.username, name)
  }
  test("A CpuPlayer can be created with no parameters") {
    assertEquals(cpu.username, "CPU")
  }
  test("Each player start with 2 gems") {
    assertEquals(player1.gems, 2)
    assertEquals(cpu.gems, 2)
  }
  test("The HumanPlayer takes the front of the board while the cpu takes the back") {
    assertEquals(player1.boardSection, "Front")
    assertEquals(cpu.boardSection, "Back")
  }
}
