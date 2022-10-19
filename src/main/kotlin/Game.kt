import Board.Board
import FinishValidator.FinishValidator
import Move.Move
import java.util.Stack

class Game(private val board: Board) {
    private val movements = Stack<Move>()

   fun move(move: Move) {
       if (!board.getTile(move.getFrom()).isOccupied()) throw Exception("Tile is Empty")
       if(!movements.isEmpty() && board.getTile(move.getFrom()).getPiece().getColor() == board.getTile(movements.peek().getTo()).getPiece().getColor()) throw Exception("Not your turn")
       board.getTile(move.getFrom()).getPiece().move(board,move)
       movements.push(move)
    }

    fun checkWinner():Boolean {
        return TODO("Implement")
    }

    fun getLastMove():Move{
        return movements.peek()
    }

    fun getLastPiece(): Piece {
       return board.getTile(movements.peek().getTo()).getPiece()
    }

}