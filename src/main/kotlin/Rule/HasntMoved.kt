package Rule

import Board.Board
import Move.Move

class HasntMoved:Rule {
    override fun validate(board: Board, move: Move): Boolean {
        return !(board.getTile(move.getFrom()).getPiece().getHasMoved())
    }
}