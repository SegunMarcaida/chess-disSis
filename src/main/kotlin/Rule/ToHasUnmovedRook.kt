package Rule

import Game
import Move.Move

class ToHasUnmovedRook :Rule{
    override fun validate(game: Game, move: Move): Boolean {
        val board = game.getBoard()
        val tile = board.getTile(move.getTo())
       return (tile.isOccupied() && tile.getPiece().getName()=="Rook" && !tile.getPiece().getHasMoved())
    }
}