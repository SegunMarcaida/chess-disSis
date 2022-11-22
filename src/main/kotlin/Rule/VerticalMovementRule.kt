package Rule

import GameState
import Move.Move
import Position.Position

class VerticalMovementRule:Rule {

    override fun validate(gameState: GameState, move: Move): Boolean {
        return move.getFrom().getPosY() == move.getTo().getPosY()
    }
}