package Rule

import GameState
import Move.Move

class AmountOfTilesRule(private val amount: Int) : Rule{

    override fun validate(gameState: GameState, move: Move): Boolean {

        return if (move.getFrom().getPosX() == move.getTo().getPosX()){
            move.getFrom().getPosY() <= move.getTo().getPosY() + amount ||  move.getFrom().getPosY() >= move.getTo().getPosY() - amount
        }else if (move.getFrom().getPosY() == move.getTo().getPosY()){

            move.getFrom().getPosX() <= move.getTo().getPosX() + amount ||  move.getFrom().getPosX() >= move.getTo().getPosX() - amount
        }else{
            (move.getFrom().getPosX() <= move.getTo().getPosX() + amount ||  move.getFrom().getPosX() >= move.getTo().getPosX() - amount) &&
                    (move.getFrom().getPosY() <= move.getTo().getPosY() + amount ||  move.getFrom().getPosY() >= move.getTo().getPosY() - amount)
        }
    }

}