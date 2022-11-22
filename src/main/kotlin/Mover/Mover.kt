package Mover

import Board.Board
import GameState
import Move.Move

interface Mover {

    fun validateMove(gameState: GameState, move: Move): Boolean

    fun move(board: Board, move: Move): Board
}
