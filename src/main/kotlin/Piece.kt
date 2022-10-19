import Board.Board
import Move.Move
import Mover.Mover
import Rule.Rule

class Piece(private val name: String, private val color: String, private val movers: List<Mover>){
    private var hasMoved: Boolean = false

    fun move(board: Board, move: Move): Board {
        for(mover in movers) {
            if(mover.validateMove(board, move)) {
                hasMoved = true
                return mover.move(board,move)
            }
        }
        throw Exception("Invalid move")
    }
    fun getName(): String = name
    fun getColor(): String = color
    fun getHasMoved(): Boolean = hasMoved



}