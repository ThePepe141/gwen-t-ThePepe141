package cl.uchile.dcc
package gwent.players

import gwent.cards.Card
import scala.collection.mutable.ListBuffer

import cl.uchile.dcc.gwent.board.BoardSection

trait Player {
  protected val username: String
  protected var gems: Int
  protected var deck: ListBuffer[Card]
  protected var hand: ListBuffer[Card]
  var boardSection: Array[BoardSection]

  def getUsername(): String

  def getGems(): Int
  
  def deckSize(): Int
  
  def shuffleDeck(): Unit
  
  def drawCard(): Unit

  def roundLost(): Unit
  
  def isDefeated(): Boolean
  def assignBoardSection(newSection: BoardSection): Unit

}
