package Rule

import GameState
import Move.Move
import Position.Position

class HorizontalMoveRule :Rule {

    override fun validate(gameState: GameState, move: Move): Boolean {
        return move.getFrom().getPosX() == move.getTo().getPosY()

    }
}