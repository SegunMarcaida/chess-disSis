package Rule

import Board.Board
import Move.Move

class IsEmptyRule:Rule {
    override fun validate(board: Board, move: Move): Boolean {
        return !(board.getTile(move.getTo()).isOccupied())
    }
}