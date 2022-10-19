package Rule

import Board.Board
import Move.Move

class DifferentColorRule:Rule {
    override fun validate(board: Board, move: Move): Boolean {
        return if (board.getTile(move.getTo()).isOccupied()){
            ( board.getTile(move.getTo()).getPiece().getColor()!= board.getTile(move.getFrom()).getPiece().getColor())
        }else{
            true
        }
    }
}