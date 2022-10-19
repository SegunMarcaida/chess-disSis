package Rule

import Board.Board
import Move.Move
import kotlin.math.abs

class AmountOfTilesRule(private val amount: Int) : Rule{

    override fun validate(board: Board, move: Move): Boolean {
        return ((abs(move.getFrom().getPosX() - move.getTo().getPosX()) + abs(move.getFrom().getPosY() - move.getTo().getPosY())) <= amount)
    }

}