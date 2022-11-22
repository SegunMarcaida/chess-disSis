package Rule

import GameState
import Move.Move

class ToHasUnmovedRook :Rule{
    override fun validate(gameState: GameState, move: Move): Boolean {
        val board = gameState.getBoard()
        val tile = board.getTile(move.getTo())
       return (tile.isOccupied() && tile.getPiece().getName()=="Rook" && !tile.getPiece().getHasMoved())
    }
}