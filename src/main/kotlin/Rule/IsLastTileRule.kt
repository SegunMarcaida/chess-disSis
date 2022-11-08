package Rule

import Game
import Move.Move

class IsLastTileRule:Rule {
    override fun validate(game: Game, move: Move): Boolean {
        val board = game.getBoard()
        println(move.getTo().getPosY())
        println(board.getNumberOfRows()-1)
        return (move.getTo().getPosY() < move.getFrom().getPosY() && move.getTo().getPosY() == 0)
                ||
                (move.getTo().getPosY() > move.getFrom().getPosY() && move.getTo().getPosY() == board.getNumberOfRows()-1)
    }

}
