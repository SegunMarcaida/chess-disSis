import Board.Board
import Move.Move

class Game(private val board: Board) {
    private var lastColor = "WHITE"

   fun move(move: Move):Board {
       if (!board.getTile(move.getFrom()).isOccupied()) throw Exception("Tile is Empty")
       if( board.getTile(move.getFrom()).getPiece().getColor() == lastColor) throw Exception("Not your turn")
       val newBoard = board.getTile(move.getFrom()).getPiece().move(this,move)
       toggleLastColor()
       return newBoard;
    }

    private fun toggleLastColor() {
        if (lastColor == "WHITE") lastColor = "BLACK"
        else if (lastColor == "BLACK") lastColor = "WHITE"
    }

    fun checkWinner():Boolean {
        return TODO("Implement")
    }



    fun getLastColor(): String {
       return lastColor
    }

    fun getBoard(): Board{
        return board
    }
}