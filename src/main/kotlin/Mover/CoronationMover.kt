package Mover

import Board.Board
import Game
import Move.Move
import PieceGenerator
import Rule.Rule

class CoronationMover(private val rules: List<Rule>):Mover {
    override fun validateMove(game: Game, move: Move): Boolean {
        println(rules.all { it.validate(game, move) })
        return rules.all { it.validate(game, move) }

    }
    private val pieceGenerator = PieceGenerator()
    override fun move(board: Board, move: Move): Board {
        val queen = pieceGenerator.queen(board.getTile(move.getFrom()).getPiece().getColor(),board.getTile(move.getFrom()).getPiece().getUniqueId());
        println(queen.getColor())
        println(queen.getName())
        println(move.getTo().getPosX())
        println(move.getTo().getPosY())
         val newBoard = board.putAt(move.getTo(),queen)
        newBoard.removePiece(move.getFrom())
        return newBoard
    }
}