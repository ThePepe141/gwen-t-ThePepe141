package cl.uchile.dcc
package gwent

trait Card {
  val name: String
  val classification: String
  
  def getName(): String
}
