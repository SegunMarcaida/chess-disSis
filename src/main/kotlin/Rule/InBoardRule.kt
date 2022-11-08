package Rule

import Game
import Move.Move

class InBoardRule: Rule{
        override fun validate(game: Game, move: Move): Boolean {
            val board = game.getBoard()

            return board.inBounds(move.getFrom()) && board.inBounds(move.getTo())
        }

}