package Rule

import GameState
import Move.Move

interface Rule {
 fun validate(gameState: GameState, move: Move): Boolean
}
