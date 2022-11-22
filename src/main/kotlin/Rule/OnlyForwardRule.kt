package Rule

import GameState
import Move.Move

class OnlyForwardRule(private val color:String):Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        return if (color == "BLACK"){

            (move.getFrom().getPosY()>move.getTo().getPosY())

        }else{
            if(move.getFrom().getPosY()<move.getTo().getPosY()){
                true
            }else{
                println("Only Forward  mdfqr")
                false
            }

        }

    }
}