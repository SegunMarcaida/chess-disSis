package Mover

import Board.Board
import Game
import Move.Move

interface Mover {

    fun validateMove(game: Game, move: Move): Boolean

    fun move(board: Board, move: Move): Board
}
