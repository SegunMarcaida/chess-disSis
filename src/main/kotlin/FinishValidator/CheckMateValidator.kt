package FinishValidator

import GameState
import Move.Move
import Position.Position

class CheckMateValidator:FinishValidator {

    override fun checkFinish(gameState: GameState): CheckFinishResult {
        val colorToCheck = if(gameState.getLastColorMove() == "WHITE") {
            "BLACK"
        }else {
            "WHITE"
        }
        val board = gameState.getActualBoardCopy()
        val pieces = board.getColorPieces(colorToCheck)
        for (piece in pieces) {
            val piecePosition = board.getPositionFromPiece(piece)
            for (i in 0 until board.getNumberOfRows()){
                for (j in 0 until board.getNumberOfColumns()){
                    val toPosition = Position(i,j)
                    if(piece.canMove(Move(piecePosition, toPosition),gameState)){
                        return NoWinnerResult()
                    }
                }
            }
        }
        return HasWinnerResult(gameState.getLastColorMove())
    }

}
