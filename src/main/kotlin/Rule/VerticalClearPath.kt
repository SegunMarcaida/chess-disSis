package Rule

import GameState
import Move.Move
import Position.Position

class VerticalClearPath:Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        if(move.getFrom().getPosX() < move.getTo().getPosX()){
            var i = move.getFrom().getPosX() + 1;
            while( i < move.getTo().getPosX()) {
                if(gameState.getBoard().getTile(Position(i, move.getFrom().getPosY())).isOccupied()){
                    return false
                }
                i += 1
            }
            return true
        }else {
            var i = move.getFrom().getPosX() - 1;
            while( i > move.getTo().getPosX()) {
                if(gameState.getBoard().getTile(Position(i, move.getFrom().getPosY())).isOccupied()){
                    return false
                }
                i -= 1
            }
            return true
        }
    }
}
