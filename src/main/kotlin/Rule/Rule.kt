package Rule

import Board.Board
import Game
import Move.Move

interface Rule {
 fun validate(game: Game, move: Move): Boolean
}
