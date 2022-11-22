package Rule

import GameState
import Move.Move

class HasntMoved:Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        val board = gameState.getBoard()

        return !(board.getTile(move.getFrom()).getPiece().getHasMoved())
    }
}