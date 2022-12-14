package Rule

import GameState
import Move.Move

class IsEmptyRule:Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        val board = gameState.getBoard()

        return !(board.getTile(move.getTo()).isOccupied())
    }
}