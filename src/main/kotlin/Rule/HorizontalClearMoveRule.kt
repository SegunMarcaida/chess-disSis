package Rule

import Board.Board
import Move.Move
import Position.Position

class HorizontalClearMoveRule :Rule {

    override fun validate(board: Board, move: Move): Boolean {
        val amountOfTiles = move.getTo().getPosX() - move.getFrom().getPosX()
        if (amountOfTiles>0){
            for (i in 1 until amountOfTiles) {
                if (board.getTile(Position(move.getFrom().getPosX() + i, move.getFrom().getPosY())).isOccupied()) {
                    return false
                }
            }
        }else{
            for (x in amountOfTiles+1..-1) {
                if (board.getTile(Position(move.getFrom().getPosX() + x, move.getFrom().getPosY())).isOccupied()) {
                    return false
                }
            }
        }
        return move.getFrom().getPosY() == move.getTo().getPosY()
    }

}