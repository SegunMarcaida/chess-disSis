package FinishValidator

import GameState

interface FinishValidator {
    fun checkFinish(gameState: GameState): CheckFinishResult
}