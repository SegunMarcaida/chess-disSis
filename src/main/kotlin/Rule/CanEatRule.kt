package Rule

import Board.Board
import Move.Move

class CanEatRule: Rule {
    override fun validate(board: Board, move: Move): Boolean {
        val tileTo = board.getTile(move.getTo())
        val tileFrom = board.getTile(move.getFrom())
        return (tileTo.isOccupied() && tileTo.getPiece().getColor() != tileFrom.getPiece().getColor())
        }
}