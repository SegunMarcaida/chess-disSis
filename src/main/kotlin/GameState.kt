import Board.Board
import edu.austral.dissis.chess.gui.Move

class GameState(
    private val movements: MutableList<Move>,
    private val initialBoard: Board,
    private val actualBoard: Board,
    private var hasFinished: Boolean,
    private var winnerColor: String,
    private var lastColorMove: String,
) {

    fun getBoard(): Board = actualBoard

    fun getActualBoardCopy(): Board = actualBoard.getCopy()

    fun getInitialBoardCopy(): Board = initialBoard.getCopy()

    fun getMovements(): MutableList<Move> = movements

    fun finishGame(color: String) {
        hasFinished = true
        winnerColor = color
    }

    fun getLastColorMove(): String {
        return lastColorMove
    }

    override fun toString(): String {
        return actualBoard.toString()
    }

    fun hasFinished(): Boolean = hasFinished

    fun getWinner(): String = winnerColor

    fun toggleLastColorMove() {
        lastColorMove = if (lastColorMove == "BLACK") {
            "WHITE"
        } else {
            "BLACK"
        }
    }

    fun getCopy(): GameState {
        return GameState(
            movements,
            initialBoard.getCopy(),
            actualBoard.getCopy(),
            hasFinished,
            winnerColor,
            lastColorMove
        )
    }
}
