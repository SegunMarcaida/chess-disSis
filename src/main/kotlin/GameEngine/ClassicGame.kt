package GameEngine

import Board.Board
import Board.RectangularBoard
import Game
import Move.Move
import Piece
import PieceGenerator
import Position.Position
import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.gui.Move as MoveGui
import edu.austral.dissis.chess.gui.PlayerColor
import edu.austral.dissis.chess.gui.Position as PositionGui


class ClassicGame {
    private val pf = PieceGenerator()
    private var board = generateBoard()

    private fun generateBoard(): Board {
        val board: Board = RectangularBoard(8, 8)
        board.putAt(Position(0, 0), pf.rook("Black"))
        board.putAt(Position(0, 1), pf.pawn("Black"))
        board.putAt(Position(1, 0), pf.knight("Black"))
        board.putAt(Position(1, 1), pf.pawn("Black"))
        board.putAt(Position(2, 0), pf.bishop("Black"))
        board.putAt(Position(2, 1), pf.pawn("Black"))
        board.putAt(Position(3, 0), pf.king("Black"))
        board.putAt(Position(3, 1), pf.pawn("Black"))
        board.putAt(Position(4, 0), pf.queen("Black"))
        board.putAt(Position(4, 1), pf.pawn("Black"))
        board.putAt(Position(5, 0), pf.bishop("Black"))
        board.putAt(Position(5, 1), pf.pawn("Black"))
        board.putAt(Position(6, 0), pf.knight("Black"))
        board.putAt(Position(6, 1), pf.pawn("Black"))
        board.putAt(Position(7, 0), pf.rook("Black"))
        board.putAt(Position(7, 1), pf.pawn("Black"))
        board.putAt(Position(0, 6), pf.pawn("White"))
        board.putAt(Position(0, 7), pf.rook("White"))
        board.putAt(Position(1, 6), pf.pawn("White"))
        board.putAt(Position(1, 7), pf.knight("White"))
        board.putAt(Position(2, 6), pf.pawn("White"))
        board.putAt(Position(2, 7), pf.bishop("White"))
        board.putAt(Position(3, 6), pf.pawn("White"))
        board.putAt(Position(3, 7), pf.king("White"))
        board.putAt(Position(4, 6), pf.pawn("White"))
        board.putAt(Position(4, 7), pf.queen("White"))
        board.putAt(Position(5, 6), pf.pawn("White"))
        board.putAt(Position(5, 7), pf.bishop("White"))
        board.putAt(Position(6, 6), pf.pawn("White"))
        board.putAt(Position(6, 7), pf.knight("White"))
        board.putAt(Position(7, 6), pf.pawn("White"))
        board.putAt(Position(7, 7), pf.rook("White"))

        return board
    }


    fun pieces(): List<ChessPiece> {
        val newPieces = mutableListOf<ChessPiece>()
        val pieces = board.getPieces()
        pieces.map { newPieces.add(pieceToUIPiece(it)) }
        return newPieces
    }

    private fun pieceToUIPiece(piece: Piece): ChessPiece {
        return ChessPiece(
            piece.hashCode().toString(), if (piece.getColor() == "Black") {
                PlayerColor.BLACK
            } else {
                PlayerColor.WHITE
            }, PositionGui(board.getPiece(piece).getPosY()+1, board.getPiece(piece).getPosX()+ 1), piece.getName().lowercase()
        )
    }



    private val game = Game(board)

    fun move(move: MoveGui) {
        val from = Position(move.from.column - 1, move.from.row-1)
        val to = Position(move.to.column - 1, move.to.row-1)
       board = game.move(Move(from,to))

    }

    fun nextMove(): PlayerColor {
        return if(game.getLastColor() == "Black") {
            PlayerColor.WHITE
        }else{
            PlayerColor.BLACK
        }
    }

}