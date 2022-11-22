import Board.Board
import FinishValidator.FinishValidator
import Move.Move
import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.gui.PlayerColor
import edu.austral.dissis.chess.gui.Position

class Game (
    private val finishValidators: List<FinishValidator>,
    private val gameState: GameState,
){

    fun getActualBoard(): Board {
        return gameState.getBoard();
    }

    fun move(move: Move): GameState  {
        if(!gameState.getBoard().getTile(move.getFrom()).isOccupied()) throw Exception("Theres no piece")
        if(gameState.getBoard().getTile(move.getFrom()).getPiece().getColor() != getNextPlayerColor()) throw Exception("Not your turn")

        val pieceToMove = gameState.getBoard().getTile(move.getFrom()).getPiece()
        pieceToMove.move( gameState,move)
        gameState.toggleLastColorMove()
        checkWinner()
        return gameState
    }

    private fun checkWinner() {
        for (validator in finishValidators) {
            val checkFinishResult = validator.checkFinish(gameState)
            if (checkFinishResult.hasWinner()) {
                gameState.finishGame(checkFinishResult.getWinnerColor())
            }
        }
    }

    private fun getNextPlayerColor(): String {
        return if(gameState.getLastColorMove() == "BLACK") {
            "WHITE"
        } else {
            "BLACK"
        }
    }

    fun getNextPlayer(): PlayerColor {
        val color = getNextPlayerColor()
        return if(color == "BLACK") {
            PlayerColor.BLACK
        }else {
            PlayerColor.WHITE
        }
    }

    fun getChessPieces(): List<ChessPiece> {
        val pieces = gameState.getBoard().getPieces()
        return pieces.map {piece ->
            ChessPiece(
                piece.getId(), if(piece.getColor() == "BLACK"){ PlayerColor.BLACK} else { PlayerColor.WHITE},
                Position(gameState.getBoard().getPositionFromPiece(piece).getPosX()+1, gameState.getBoard().getPositionFromPiece(piece).getPosY()+1), piece.getName().lowercase()
            )
        }
    }

    fun hasFinished(): Boolean {
        return gameState.hasFinished()
    }

    fun getWinner(): PlayerColor {
        val color = gameState.getWinner()
        return if(color == "BLACK") {
            PlayerColor.BLACK
        }else {
            PlayerColor.WHITE
        }
    }

    override fun toString(): String = gameState.toString()

}