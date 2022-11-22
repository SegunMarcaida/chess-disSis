import Mover.CastlingMover
import Mover.CoronationMover
import Mover.SimpleMover
import Rule.*

class PieceGenerator {
    fun    pawn(id: String?,color:String,):Piece{
        return Piece("Pawn",color, listOf(
                CoronationMover(listOf(VerticalMovementRule(),VerticalClearPath(),AmountOfTilesRule(1),DifferentTileRule(),InBoardRule(),CheckRule(),IsEmptyRule(),OnlyForwardRule(color),IsLastTileRule())),
                CoronationMover(listOf(DiagonalClearMoveRule(),AmountOfTilesRule(1),DifferentTileRule(),InBoardRule(),CheckRule(),OnlyForwardRule(color),IsLastTileRule(),CanEatRule(),DiagonalClearMoveRule())),
                SimpleMover(listOf(DiagonalClearMoveRule(),AmountOfTilesRule(1),DifferentTileRule(),InBoardRule(),OnlyForwardRule(color),DiagonalClearMoveRule(),CanEatRule())),
                SimpleMover(listOf(VerticalMovementRule(),VerticalClearPath(),AmountOfTilesRule(1),DifferentTileRule(),InBoardRule(),CheckRule(),IsEmptyRule(),OnlyForwardRule(color))),
                SimpleMover(listOf(VerticalMovementRule(),VerticalClearPath(),AmountOfTilesRule(2),HasntMoved(),DifferentTileRule(),InBoardRule(),CheckRule(),IsEmptyRule()))
        ))
    }

    fun bishop(id: String?,color:String):Piece{
        return Piece("Bishop",color, listOf(
                SimpleMover(listOf(DiagonalClearMoveRule() ,DifferentTileRule(),InBoardRule(),CheckRule(),DifferentColorRule()))
        ))
    }
    fun knight(id: String?,color:String):Piece{
        return Piece("Knight",color, listOf(SimpleMover(listOf(KnightMoveRule(),DifferentTileRule(),InBoardRule(),CheckRule(),DifferentColorRule()))))
    }
    fun rook(id: String?,color:String):Piece{
        return Piece("Rook",color, listOf(
            SimpleMover(listOf(VerticalMovementRule(),VerticalClearPath(),InBoardRule(),CheckRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(HorizontalMoveRule(),HorizontalClearPath(),InBoardRule(),CheckRule(),DifferentTileRule(),DifferentColorRule()))
            ))
    }
    fun queen(id: String?,color:String):Piece{
        return Piece("Queen",color, listOf(
            SimpleMover(listOf(VerticalMovementRule(),VerticalClearPath(),InBoardRule(),CheckRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(HorizontalMoveRule(),HorizontalClearPath(),InBoardRule(),CheckRule(),DifferentTileRule(),DifferentColorRule())),
            SimpleMover(listOf(DiagonalClearMoveRule(),InBoardRule(),CheckRule(),DifferentTileRule(),DifferentColorRule()))
        ))
    }
    fun king(id: String?,color:String):Piece{
        return Piece("King",color, listOf(
            CastlingMover(listOf(HorizontalMoveRule(),HorizontalClearPath(),ToHasUnmovedRook(),HasntMoved(),DifferentTileRule(),InBoardRule(),CheckRule())),
            SimpleMover(listOf(VerticalMovementRule(),VerticalClearPath(),InBoardRule(),CheckRule(),DifferentTileRule(),AmountOfTilesRule(1),DifferentColorRule())),
            SimpleMover(listOf(HorizontalMoveRule(),HorizontalClearPath(),InBoardRule(),CheckRule(),DifferentTileRule(),AmountOfTilesRule(1),DifferentColorRule())),
            SimpleMover(listOf(DiagonalClearMoveRule(),InBoardRule(),CheckRule(),DifferentTileRule(),AmountOfTilesRule(2),DifferentColorRule()))
        ))
    }
}