package Rule

import Game
import Move.Move
import Position.Position
import kotlin.math.abs

class DiagonalClearMoveRule :Rule{

    override fun validate(game: Game, move: Move): Boolean {
        val board = game.getBoard()

        val amountOfTilesX = move.getTo().getPosX() - move.getFrom().getPosX()
        val amountOfTilesY = move.getTo().getPosY() - move.getFrom().getPosY()
        if (amountOfTilesX>0){
            if (amountOfTilesY>0){
                for (i in 1 until amountOfTilesX){
                    if (board.getTile(Position(move.getFrom().getPosX() + i, move.getFrom().getPosY()  + i)).isOccupied()){
                        return false
                    }
                }
            }else{
                for (i in 1 until amountOfTilesX){
                    if (board.getTile(Position(move.getFrom().getPosX() + i, move.getFrom().getPosY() - i)).isOccupied()){
                        return false
                    }
                }
            }

        }else{
            if (amountOfTilesY>0){
                for (i in amountOfTilesX+1..-1){
                    if (board.getTile(Position(move.getFrom().getPosX() + i, move.getFrom().getPosY() - i)).isOccupied()){
                        return false
                    }
                }
            }else{
                for (i in amountOfTilesX+1..-1){
                    if (board.getTile(Position(move.getFrom().getPosX() + i, move.getFrom().getPosY() + i)).isOccupied()){
                        return false
                    }
                }
            }
        }

        return abs(move.getFrom().getPosX() - move.getTo().getPosX()) == abs(move.getFrom().getPosY() - move.getTo().getPosY())
    }

}