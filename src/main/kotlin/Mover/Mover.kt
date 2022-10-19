package Mover

import Board.Board
import Move.Move

interface Mover {

    fun validateMove(board: Board, move: Move): Boolean

    fun move(board: Board, move: Move): Board
}
