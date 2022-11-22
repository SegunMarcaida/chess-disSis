package Mover

import Board.Board
import GameState
import Move.Move
import PieceGenerator
import Rule.Rule

class CoronationMover(private val rules: List<Rule>):Mover {
    override fun validateMove(gameState: GameState, move: Move): Boolean {
        return rules.all { it.validate(gameState, move) }

    }
    private val pieceGenerator = PieceGenerator()
    override fun move(board: Board, move: Move): Board {
        val queen = pieceGenerator.queen(board.getTile(move.getFrom()).getPiece().getColor(),board.getTile(move.getFrom()).getPiece().getUniqueId());
         val newBoard = board.putAt(move.getTo(),queen)
        newBoard.removePiece(move.getFrom())
        return newBoard
    }
}