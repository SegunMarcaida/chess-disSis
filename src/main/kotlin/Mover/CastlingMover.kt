package Mover

import Board.Board
import Game
import Move.Move
import Position.Position
import Rule.Rule

class CastlingMover(private val rules: List<Rule>) :Mover{
    override fun validateMove(game: Game, move: Move): Boolean {
        return rules.all { it.validate(game, move) }

    }

    override fun move(board: Board, move: Move): Board {


        val shortCastling = move.getTo().getPosX() < move.getFrom().getPosX()

         if (shortCastling){
            val newBoard = board.putAt( Position(move.getFrom().getPosX()-2, move.getTo().getPosY()),board.getTile(move.getFrom()).getPiece())
            newBoard.removePiece(move.getFrom())
            val rookBoard = newBoard.putAt( Position(move.getTo().getPosX()+2, move.getTo().getPosY()),board.getTile(move.getTo()).getPiece())
            rookBoard.removePiece(move.getTo())
            return rookBoard;

        }else{
            val newBoard = board.putAt( Position(move.getFrom().getPosX()+2, move.getTo().getPosY()),board.getTile(move.getFrom()).getPiece())
            newBoard.removePiece(move.getFrom())
            val rookBoard = newBoard.putAt( Position(move.getTo().getPosX()-3, move.getTo().getPosY()),board.getTile(Position(move.getTo().getPosX(), move.getTo().getPosY())).getPiece(),)
            rookBoard.removePiece(move.getTo())
            return rookBoard;

        }
    }

}