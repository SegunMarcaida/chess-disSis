package Rule

import GameState
import Move.Move

class  CheckRule : Rule{
    override fun validate(gameState: GameState, move: Move): Boolean {

        val gameStateCopy = gameState.getCopy()
        val board = gameStateCopy.getBoard()

        val oldFromTile = board.getTile(move.getFrom())
        val oldToTile = board.getTile(move.getTo())

        val playerColor = board.getTile(move.getFrom()).getPiece().getColor()

        //if not it throws error when it looks for the king
        if(oldToTile.isOccupied() && oldToTile.getPiece().getColor() == playerColor && oldToTile.getPiece().getName() == "King"){
            return false
        }

        board.putAt(move.getTo(), oldFromTile.getPiece())
        board.removePiece(move.getFrom())

        val playerPieces = board.getColorPieces(playerColor)

        val playerKing = playerPieces.find { piece -> piece.getName() == "King" } ?: throw Error("king not found")

        val oppositePieces = if(playerColor == "WHITE") {
            board.getColorPieces("BLACK")
        } else {
            board.getColorPieces("WHITE")
        }

        val playerKingPosition = board.getPositionFromPiece(playerKing)

        for (piece in oppositePieces){
            val toKingMovement = Move(board.getPositionFromPiece(piece), playerKingPosition)
            if(piece.canMove(toKingMovement, gameStateCopy.getCopy())){
                return false
            }
        }
        return true
    }
}
