package Rule

import Game
import Move.Move

class HasntMoved:Rule {
    override fun validate(game: Game, move: Move): Boolean {
        val board = game.getBoard()

        return !(board.getTile(move.getFrom()).getPiece().getHasMoved())
    }
}