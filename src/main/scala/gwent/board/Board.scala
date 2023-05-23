package cl.uchile.dcc
package gwent.board

import gwent.players.{CpuPlayer, HumanPlayer}

/** A class that represents the Board of a match. It requires 2 Players.
 * 
 * @param player1 The HumanPlayer of the match.
 * @param player2 The CpuPlayer of the match.
 */
class Board(val player1: HumanPlayer, val player2: CpuPlayer) {

  /** The round currently at play.
   */
  var round: Int = 1

  /** BoardSection for HumanPlayer.
   */
  var Front: BoardSection = new BoardSection()

  /**BoardSection for CpuPlayer.
   */
  var Back: BoardSection = new BoardSection()

  /** It gives to each Player a specific number of Cards.
   * 
   * The number depends of the round. Round 1 -> 10 Cards, Other round -> 3 Cards
   */
  def handOutCards(): Unit = {
    if (round==1){
      for (a <- 1 to 10) {
        player1.drawCard
        player2.drawCard
      }
    }
    else {
      for (a <- 1 to 3) {
        player1.drawCard
        player2.drawCard
      }
    }
  }

  /** Initiate a match.
   * 
   * Verify limit number of Cards in each deck, assign sections of the Board
   * and suffle the decks.
   */
  def startMatch: Unit = {
    assert(player1.deckSize >= 25)
    assert(player2.deckSize >= 25)

    player1.assignBoardSection(Front)
    player2.assignBoardSection(Back)

    player1.shuffleDeck
    player2.shuffleDeck
  }

  /** Start a round
   * 
   * Hand out Cards to each Player.
   */
  def startRound: Unit = {
    handOutCards()
  }

}
