import Board.RectangularBoard
import FinishValidator.CheckMateValidator
import FinishValidator.FinishValidator
import Position.Position
import Tile.OccupiedTile

class ClassicGame(
    private val rectangularBoard: RectangularBoard,
    private val pieceGenerator: PieceGenerator
) {

    companion object Create {
        fun createFactory(): ClassicGame{
            return ClassicGame(
                RectangularBoard(8,8),
                PieceGenerator()
            )
        }
    }

    fun create(): Game {
        val finishValidators = listOf<FinishValidator>(
            CheckMateValidator()
        )
        val board = rectangularBoard
       /* for (i in 0..7) {
            board.putAt(Position(1,i),  pieceGenerator.pawn("1$i", "WHITE"))
            board.putAt(Position(6,i),  pieceGenerator.pawn("6$i", "BLACK"))
        }*/
      /*  board.putAt(
            Position(0,0),
            pieceGenerator.rook("00", "WHITE"))
        board.putAt(
            Position(0,7),
             pieceGenerator.rook("07", "WHITE")
        )
        board.putAt(
            Position(0,2),
              pieceGenerator.bishop("01", "WHITE")
        )
        board.putAt(
            Position(0,5),
             pieceGenerator.bishop("06", "WHITE")
        )
        board.putAt(
            Position(0,1),
            pieceGenerator.knight("02", "WHITE")
        )
        board.putAt(
            Position(0,6),
              pieceGenerator.knight("05", "WHITE")
        )
        board.putAt(
            Position(0,3),
            pieceGenerator.queen("03", "WHITE")
        )*/
        board.putAt(
            Position(0,5),
             pieceGenerator.king("04", "WHITE")
        )

        board.putAt(
            Position(7,0),
              pieceGenerator.rook("70", "BLACK")
        )
       /* board.putAt(
            Position(7,7),
              pieceGenerator.rook("77", "BLACK")
        )*/
        /*board.putAt(
            Position(7,2),
              pieceGenerator.bishop("71", "BLACK")
        )*/
       /* board.putAt(
            Position(7,5),
             pieceGenerator.bishop("76", "BLACK")
        )
        board.putAt(
            Position(7,1),
              pieceGenerator.knight("72", "BLACK")
        )
        board.putAt(
            Position(7,6),
             pieceGenerator.knight("75", "BLACK")
        )*/
        board.putAt(
            Position(7,3),
             pieceGenerator.queen("73", "BLACK")
        )
        board.putAt(
            Position(7,4),
              pieceGenerator.king("74", "BLACK")
        )

        return Game(
            finishValidators,
            GameState(
                mutableListOf(),
                board,
                board.getCopy(),
                false,
                "",
                "BLACK"
            )
        )
    }

}