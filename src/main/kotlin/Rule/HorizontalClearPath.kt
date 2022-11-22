package Rule

import GameState
import Move.Move
import Position.Position

class HorizontalClearPath:Rule {
    override fun validate(gameState: GameState, move: Move): Boolean {
        if(move.getFrom().getPosY() < move.getTo().getPosY()){
            var i = move.getFrom().getPosY() + 1;
            while( i < move.getTo().getPosY()) {
                if(gameState.getBoard().getTile(Position(move.getFrom().getPosX(), i)).isOccupied()){
                    return false
                }
                i += 1
            }
            return true
        }else {
            var i = move.getFrom().getPosY() - 1;
            while( i > move.getTo().getPosY()) {
                if(gameState.getBoard().getTile(Position(move.getFrom().getPosX(), i)).isOccupied()){
                    return false
                }
                i -= 1
            }
            return true
        }
    }
}