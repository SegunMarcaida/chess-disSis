package Mover

import Board.Board
import Move.Move
import Rule.Rule

class SimpleMover(private val rules: List<Rule>):Mover {

    override fun validateMove(board: Board, move: Move): Boolean {
        return rules.all{it.validate(board,move)}
    }

    override fun move(board: Board, move: Move): Board {
        board.putAt(move.getTo(),board.getTile(move.getFrom()).getPiece())
        board.removePiece(move.getFrom())
        return board
    }
}