package Rule

import GameState
import Move.Move

class DifferentColorRule:Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        val board = gameState.getBoard()

        return if (board.getTile(move.getTo()).isOccupied()){
            ( board.getTile(move.getTo()).getPiece().getColor()!= board.getTile(move.getFrom()).getPiece().getColor())
        }else{
            true
        }
    }
}