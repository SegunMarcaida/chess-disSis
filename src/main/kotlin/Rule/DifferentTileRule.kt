package Rule

import Board.Board
import Move.Move

class DifferentTileRule:Rule {
    override fun validate(board: Board, move: Move): Boolean {
        return move.getFrom() != move.getTo()
    }
}