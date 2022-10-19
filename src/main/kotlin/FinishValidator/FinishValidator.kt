package FinishValidator

import Board.Board

interface FinishValidator {
    fun checkFinish(board: Board): Boolean
}