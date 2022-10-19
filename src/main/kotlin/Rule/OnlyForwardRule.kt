package Rule

import Board.Board
import Move.Move

class OnlyForwardRule(private val color:String):Rule {
    override fun validate(board: Board, move: Move): Boolean {
        return if (color == "White"){
            (move.getFrom().getPosY()>move.getTo().getPosY())
        }else{
            (move.getFrom().getPosY()<move.getTo().getPosY())

        }

    }
}