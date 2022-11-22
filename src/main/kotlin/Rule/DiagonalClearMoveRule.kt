package Rule

import GameState
import Move.Move
import kotlin.math.abs

class DiagonalClearMoveRule :Rule{

    override fun validate(gameState: GameState, move: Move): Boolean {

        return if(abs(move.getFrom().getPosX() - move.getTo().getPosX()) == abs(move.getFrom().getPosY() - move.getTo().getPosY())){

            true
        }else{
            false
        }
    }

}