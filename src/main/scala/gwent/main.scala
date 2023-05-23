package cl.uchile.dcc

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import gwent.cards.Card
import gwent.players.{HumanPlayer, CpuPlayer}
import gwent.board.{Board, BoardSection}

@main
def main(): Unit = {
  println("Hello world!")
  println("Welcome to Gwent Card Game!!!!")
  println("Enter your name for the match")
  val username = readLine()

  var player1 = new HumanPlayer(username, ListBuffer[Card]())
  var player2 = new CpuPlayer(ListBuffer[Card]())

  var gwentBoard = new Board(player1, player2)

  println("Choose the Cards for your deck")


}