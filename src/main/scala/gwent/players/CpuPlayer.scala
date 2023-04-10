package cl.uchile.dcc
package gwent.players
import gwent.{Card, Player}

class CpuPlayer extends Player{
  override val username: String = "CPU"
  override val boardSection: String = "Back"
  var gems: Int = 2

  override def getUsername(): String = username

}
