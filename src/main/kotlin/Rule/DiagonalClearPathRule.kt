package Rule

import GameState
import Move.Move
import Position.Position

class DiagonalClearPathRule: Rule  {
    override fun validate(gameState: GameState, move:Move): Boolean {
        if (move.getFrom().getPosX() > move.getTo().getPosX() && move.getFrom().getPosY() > move.getTo()
                .getPosY()
        ) {
            var i = move.getFrom().getPosX() - 1;
            var j = move.getFrom().getPosY() - 1;
            while (i > move.getTo().getPosX() && j > move.getTo().getPosY()) {
                if (gameState.getActualBoardCopy().getTile(Position(i, j)).isOccupied()) {
                    return false
                }
                i -= 1
                j -= 1
            }
            return true
        } else if (move.getFrom().getPosX() > move.getTo().getPosX() && move.getFrom().getPosY() < move.getTo()
                .getPosY()
        ) {
            var i = move.getFrom().getPosX() - 1;
            var j = move.getFrom().getPosY() + 1;
            while (i > move.getTo().getPosX() && j < move.getTo().getPosY()) {
                if (gameState.getActualBoardCopy().getTile(Position(i, j)).isOccupied()) {
                    return false
                }
                i -= 1
                j += 1
            }
            return true
        } else if (move.getFrom().getPosX() < move.getTo().getPosX() && move.getFrom().getPosY() > move.getTo()
                .getPosY()
        ) {
            var i = move.getFrom().getPosX() + 1;
            var j = move.getFrom().getPosY() - 1;
            while (i < move.getTo().getPosX() && j > move.getTo().getPosY()) {
                if (gameState.getActualBoardCopy().getTile(Position(i, j)).isOccupied()) {
                    return false
                }
                i += 1
                j -= 1
            }
            return true
        } else {
            var i = move.getFrom().getPosX() + 1;
            var j = move.getFrom().getPosY() + 1;
            while (i < move.getTo().getPosX() && j < move.getTo().getPosY()) {
                if (gameState.getActualBoardCopy().getTile(Position(i, j)).isOccupied()) {
                    return false
                }
                i += 1
                j += 1
            }
            return true
        }
    }
}