package Rule

import GameState
import Move.Move

class InBoardRule: Rule{
        override fun validate(gameState: GameState, move: Move): Boolean {
            val board = gameState.getBoard()

            return board.inBounds(move.getFrom()) && board.inBounds(move.getTo())
        }

}