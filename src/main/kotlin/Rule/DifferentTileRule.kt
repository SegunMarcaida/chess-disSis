package Rule

import Board.Board
import Game
import Move.Move

class DifferentTileRule:Rule {
    override fun validate(game: Game, move: Move): Boolean {
        return move.getFrom() != move.getTo()
    }
}