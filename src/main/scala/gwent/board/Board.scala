package cl.uchile.dcc
package gwent.board

import gwent.players.{CpuPlayer, HumanPlayer}

class Board(val player1: HumanPlayer, val player2: CpuPlayer) {
  
  var round: Int = 1
  
  def handOutCards(): Unit = {
    if (round==1){
      for (a <- 1 to 10) {
        player1.drawCard()
        player2.drawCard()
      }
    }
    else {
      for (a <- 1 to 3) {
        player1.drawCard()
        player2.drawCard()
      }
    }
  }

  assert(player1.deckSize()>=25)
  assert(player2.deckSize()>=25)

  var Front: BoardSection = new BoardSection()
  var Back: BoardSection = new BoardSection()

  player1.assignBoardSection(Front)
  player2.assignBoardSection(Back)

  player1.shuffleDeck()
  player2.shuffleDeck()
  
  handOutCards()

}
