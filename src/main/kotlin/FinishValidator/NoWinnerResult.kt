package FinishValidator

import Game

class NoWinnerResult: CheckFinishResult{
    override fun hasWinner(): Boolean {
       return false
    }

    override fun getWinnerColor(): String {
        return "NO WINNER YET"
    }

}