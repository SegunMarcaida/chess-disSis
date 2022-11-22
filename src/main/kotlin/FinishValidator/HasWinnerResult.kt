package FinishValidator

class HasWinnerResult(private val color:String):CheckFinishResult{
    override fun hasWinner(): Boolean {
        return true;
    }

    override fun getWinnerColor(): String {
        return color
    }

}