package Mover

import Board.Board
import Game
import Move.Move
import Rule.Rule

class SimpleMover(private val rules: List<Rule>):Mover {

    override fun validateMove(game: Game, move: Move): Boolean {
        return rules.all{it.validate(game,move)}
    }

    override fun move(board: Board, move: Move): Board {
        board.putAt(move.getTo(),board.getTile(move.getFrom()).getPiece())
        board.removePiece(move.getFrom())
        return board
    }
}