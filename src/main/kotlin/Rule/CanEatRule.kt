package Rule

import Game
import Move.Move

class CanEatRule: Rule {
    override fun validate(game: Game, move: Move): Boolean {
        val board = game.getBoard()
        val tileTo = board.getTile(move.getTo())
        val tileFrom = board.getTile(move.getFrom())
        return (tileTo.isOccupied() && tileTo.getPiece().getColor() != tileFrom.getPiece().getColor())
        }
}