package Rule

import Game
import Move.Move

class DifferentColorRule:Rule {
    override fun validate(game: Game, move: Move): Boolean {
        val board = game.getBoard()

        return if (board.getTile(move.getTo()).isOccupied()){
            ( board.getTile(move.getTo()).getPiece().getColor()!= board.getTile(move.getFrom()).getPiece().getColor())
        }else{
            true
        }
    }
}