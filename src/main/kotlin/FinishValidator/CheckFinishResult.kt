package FinishValidator

interface CheckFinishResult {
    fun hasWinner(): Boolean
    fun getWinnerColor(): String
}