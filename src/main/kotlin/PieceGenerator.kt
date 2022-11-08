import Mover.CastlingMover
import Mover.CoronationMover
import Mover.SimpleMover
import Rule.*

class PieceGenerator {
    fun pawn(color:String,):Piece{
        return Piece("Pawn",color, listOf(
                CoronationMover(listOf(VerticalClearMoveRule(),AmountOfTilesRule(1),DifferentTileRule(),InBoardRule(),IsEmptyRule(),OnlyForwardRule(color),IsLastTileRule())),
                CoronationMover(listOf(DiagonalClearMoveRule(),AmountOfTilesRule(1),DifferentTileRule(),InBoardRule(),IsEmptyRule(),OnlyForwardRule(color),IsLastTileRule(),CanEatRule())),
                SimpleMover(listOf(VerticalClearMoveRule(),AmountOfTilesRule(1),DifferentTileRule(),InBoardRule(),IsEmptyRule(),OnlyForwardRule(color))),
                SimpleMover(listOf(DiagonalClearMoveRule(),AmountOfTilesRule(1),CanEatRule(),DifferentTileRule(),InBoardRule(),DifferentColorRule(),OnlyForwardRule(color))),
                SimpleMover(listOf(VerticalClearMoveRule(),AmountOfTilesRule(2),HasntMoved(),DifferentTileRule(),InBoardRule(),IsEmptyRule()))
        ))
    }

    fun bishop(color:String):Piece{
        return Piece("Bishop",color, listOf(
                SimpleMover(listOf(DiagonalClearMoveRule() ,DifferentTileRule(),InBoardRule(),DifferentColorRule()))
        ))
    }
    fun knight(color:String):Piece{
        return Piece("Knight",color, listOf(SimpleMover(listOf(KnightMoveRule(),DifferentTileRule(),InBoardRule(),DifferentColorRule()))))
    }
    fun rook(color:String):Piece{
        return Piece("Rook",color, listOf(
            SimpleMover(listOf(VerticalClearMoveRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(HorizontalClearMoveRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule()))
            ))
    }
    fun queen(color:String,id: String? = null):Piece{
        return Piece("Queen",color, listOf(
            SimpleMover(listOf(VerticalClearMoveRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(HorizontalClearMoveRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(DiagonalClearMoveRule(),InBoardRule(),DifferentTileRule(),DifferentColorRule()))
        ))
    }
    fun king(color:String):Piece{
        return Piece("King",color, listOf(
            CastlingMover(listOf(HorizontalClearMoveRule(),ToHasUnmovedRook(),HasntMoved(),DifferentTileRule(),InBoardRule())),
            SimpleMover(listOf(VerticalClearMoveRule(),InBoardRule(),DifferentTileRule(),AmountOfTilesRule(1),DifferentColorRule())),
            SimpleMover(listOf(HorizontalClearMoveRule(),InBoardRule(),DifferentTileRule(),AmountOfTilesRule(1),DifferentColorRule())),
            SimpleMover(listOf(DiagonalClearMoveRule(),InBoardRule(),DifferentTileRule(),AmountOfTilesRule(2),DifferentColorRule()))
        ))
    }
}