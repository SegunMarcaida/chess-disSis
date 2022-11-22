import Board.Board
import Move.Move
import Mover.Mover

class Piece(private val name: String, private val color: String, private val movers: List<Mover>,private var uniqueId: String? = null
){
    private var hasMoved: Boolean = false
    private val id: String = this.hashCode().toString()
    fun getUniqueId(): String {
        if (uniqueId.isNullOrBlank()){
            uniqueId = this.hashCode().toString()
        }
        return uniqueId!!
    }
    fun getId() = id
    fun move(gameState: GameState, move: Move): Board {
        for(mover in movers) {
            if(mover.validateMove(gameState, move)) {
                hasMoved = true
                return mover.move(gameState.getBoard(), move);
            }
        }
        throw Exception("Invalid move")
    }
    fun getName(): String = name
    fun getColor(): String = color
    fun getHasMoved(): Boolean = hasMoved

    fun canMove(move: Move, gameState: GameState): Boolean {
        for(mover in movers) {
            if(mover.validateMove( gameState,move)) {
                return true
            }
        }
        return false
    }

}