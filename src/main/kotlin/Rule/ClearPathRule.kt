package Rule

import Board.Board
import Move.Move

class ClearPathRule:Rule{
    override fun validate(board: Board, move: Move): Boolean {
        return true
    }

}