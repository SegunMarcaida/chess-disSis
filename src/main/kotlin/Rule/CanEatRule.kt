package Rule

import GameState
import Move.Move

class CanEatRule: Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        val board = gameState.getBoard()
        val tileTo = board.getTile(move.getTo())
        val tileFrom = board.getTile(move.getFrom())
        return (tileTo.isOccupied() && tileTo.getPiece().getColor() != tileFrom.getPiece().getColor())
        }
}