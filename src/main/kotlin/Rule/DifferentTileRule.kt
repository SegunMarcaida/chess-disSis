package Rule

import GameState
import Move.Move

class DifferentTileRule:Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        return move.getFrom() != move.getTo()
    }
}