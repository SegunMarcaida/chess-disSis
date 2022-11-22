package Rule

import GameState
import Move.Move

class KnightMoveRule : Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        return  (move.getFrom().getPosX() == move.getTo().getPosX() + 1 || move.getFrom().getPosX() == move.getTo().getPosX() - 1) &&
                (move.getFrom().getPosY() == move.getTo().getPosY() + 2 || move.getFrom().getPosY() == move.getTo().getPosY() - 2) ||
                (move.getFrom().getPosX() == move.getTo().getPosX() + 2 || move.getFrom().getPosX() == move.getTo().getPosX() - 2) &&
                (move.getFrom().getPosY() == move.getTo().getPosY() + 1 || move.getFrom().getPosY() == move.getTo().getPosY() - 1)
    }

}
