package Rule

import Board.Board
import Game
import Move.Move

class OnlyForwardRule(private val color:String):Rule {
    override fun validate(game: Game, move: Move): Boolean {
        return if (color == "White"){
            (move.getFrom().getPosY()>move.getTo().getPosY())
        }else{
            (move.getFrom().getPosY()<move.getTo().getPosY())

        }

    }
}