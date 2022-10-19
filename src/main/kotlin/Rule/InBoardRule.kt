package Rule

import Board.Board
import Move.Move

class InBoardRule: Rule{
        override fun validate(board: Board, move: Move): Boolean {
            return board.inBounds(move.getFrom()) && board.inBounds(move.getTo())
        }

}