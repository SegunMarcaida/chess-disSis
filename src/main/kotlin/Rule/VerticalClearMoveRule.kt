package Rule

import Game
import Move.Move
import Position.Position

class VerticalClearMoveRule:Rule {

    override fun validate(game: Game, move: Move): Boolean {
        val board = game.getBoard()

        val amountOfTiles = move.getTo().getPosY() - move.getFrom().getPosY()
        if (amountOfTiles > 0) {
            for (i in 1 until amountOfTiles) {
                if (board.getTile(Position(move.getFrom().getPosX(), move.getFrom().getPosY() + i)).isOccupied()) {
                    return false
                }
            }
        } else {
            for (i in amountOfTiles + 1..-1) {
                if (board.getTile(Position(move.getFrom().getPosX(), move.getFrom().getPosY() + i)).isOccupied()) {
                    return false
                }
            }
        }
        return move.getFrom().getPosX() == move.getTo().getPosX()
    }
}