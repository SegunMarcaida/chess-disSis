import Mover.SimpleMover
import Rule.*

class PieceGenerator {
    fun pawn(color:String,):Piece{
        return Piece("Pawn",color, listOf(
                SimpleMover(listOf(VerticalClearMoveRule(),AmountOfTilesRule(1),DifferentTileRule(),InBoardRule(),DifferentColorRule(),IsEmptyRule(),OnlyForwardRule(color))),
                SimpleMover(listOf(DiagonalClearMoveRule(),AmountOfTilesRule(2),CanEatRule(),DifferentTileRule(),InBoardRule(),DifferentColorRule(),OnlyForwardRule(color))),
                SimpleMover(listOf(VerticalClearMoveRule(),AmountOfTilesRule(2),HasntMoved(),DifferentTileRule(),InBoardRule(),DifferentColorRule(),IsEmptyRule(),OnlyForwardRule(color)))
        ))
    }

    fun bishop(color:String):Piece{
        return Piece("Bishop",color, listOf(
                SimpleMover(listOf(DiagonalClearMoveRule(),ClearPathRule(),DifferentTileRule(),InBoardRule(),DifferentColorRule()))
        ))
    }
    fun knight(color:String):Piece{
        return Piece("Knight",color, listOf(SimpleMover(listOf(KnightMoveRule(),DifferentTileRule(),InBoardRule(),DifferentColorRule()))))
    }
    fun rook(color:String):Piece{
        return Piece("Rook",color, listOf(
            SimpleMover(listOf(VerticalClearMoveRule(),ClearPathRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(HorizontalClearMoveRule(),ClearPathRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule()))
            ))
    }
    fun queen(color:String):Piece{
        return Piece("Queen",color, listOf(
            SimpleMover(listOf(VerticalClearMoveRule(),ClearPathRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(HorizontalClearMoveRule(),ClearPathRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(DiagonalClearMoveRule(),ClearPathRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule()))
        ))
    }
    fun king(color:String):Piece{
        return Piece("King",color, listOf(
            SimpleMover(listOf(VerticalClearMoveRule(),ClearPathRule(),InBoardRule(),DifferentTileRule(),AmountOfTilesRule(2),DifferentColorRule())),
            SimpleMover(listOf(HorizontalClearMoveRule(),ClearPathRule(),InBoardRule(),DifferentTileRule(),AmountOfTilesRule(1),DifferentColorRule())),
            SimpleMover(listOf(DiagonalClearMoveRule(),ClearPathRule(),InBoardRule(),DifferentTileRule(),AmountOfTilesRule(1),DifferentColorRule()))
        ))
    }
}