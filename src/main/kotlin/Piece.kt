import Board.Board
import Move.Move
import Mover.Mover

class Piece(private val name: String, private val color: String, private val movers: List<Mover>,private var uniqueId: String? = null
){
    private var hasMoved: Boolean = false
    private val id: String = name.lowercase() + color.lowercase()
    fun getUniqueId(): String {
        if (uniqueId.isNullOrBlank()){
            uniqueId = this.hashCode().toString()
        }
        return uniqueId!!
    }
    fun move(game: Game, move: Move): Board {
        for(mover in movers) {
            if(mover.validateMove(game, move)) {
                hasMoved = true
                return mover.move(game.getBoard(), move);
            }
        }
        throw Exception("Invalid move")
    }
    fun getName(): String = name
    fun getColor(): String = color
    fun getHasMoved(): Boolean = hasMoved



}