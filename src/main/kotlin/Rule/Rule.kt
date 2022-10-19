package Rule

import Board.Board
import Move.Move

interface Rule {
 fun validate(board: Board, move: Move): Boolean
}
