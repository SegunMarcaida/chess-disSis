package Board

import Piece
import Position.Position
import Tile.EmptyTile
import Tile.OccupiedTile
import Tile.Tile

fun RectangularBoard(boardWidth: Int, boardHeight:Int) = RectangularBoard(Array(boardWidth)  {Array(boardHeight){EmptyTile()}})

class RectangularBoard(private val boardArray:Array<Array<Tile>>) :Board {


    override fun getTile(position: Position): Tile {
        if (position.getPosX() >= 0 && position.getPosY() >= 0 && position.getPosX() <= boardArray.size && position.getPosY() <= boardArray[0].size){
           return boardArray[position.getPosX()][position.getPosY()]
        }
        throw Exception("position out of board")
    }


    override fun putAt( position: Position,piece: Piece): Board {
        val boardArrayCopy = boardArray.clone()
        boardArrayCopy[position.getPosX()][position.getPosY()] = OccupiedTile(piece)
        return RectangularBoard(boardArrayCopy)
    }



    override fun inBounds(position: Position): Boolean {
        return (boardArray.size>= position.getPosX() && boardArray[0].size >= position.getPosY() )
    }

    override fun removePiece(position: Position): Board {
        val oldPiece = getTile(position).getPiece()
        val boardArrayCopy = boardArray.clone()
        boardArrayCopy[position.getPosX()][position.getPosY()] = EmptyTile()
        return RectangularBoard(boardArrayCopy)
    }

    override fun getPieces(): List<Piece> {
        val list = mutableListOf<Piece>()
        for (i in boardArray.indices){
            for (j in boardArray[i].indices){
                if (boardArray[i][j].isOccupied()){
                    list.add(boardArray[i][j].getPiece())
                }

            }

        }
        return list
    }

    override fun getPiece(piece: Piece): Position {
        for (i in boardArray.indices){
            for (j in boardArray[i].indices){
                if (boardArray[i][j].isOccupied() && boardArray[i][j].getPiece()==  piece){
                    return Position(i,j)
                }

            }

        }
        throw Exception("no piece")
    }

    override fun getCopy(): Board {
        val newBoardArray = Array(8) { arrayOfNulls<Tile>(8) }
        for (i in boardArray.indices) {
            for (j in 0 until boardArray[i].size) {
                val tile = boardArray[i][j]
                if (tile.isOccupied()) {
                    newBoardArray[i][j] = OccupiedTile(
                        tile.getPiece()
                    )
                } else {
                    newBoardArray[i][j] = EmptyTile()
                }
            }
        }
        return RectangularBoard(
            newBoardArray as Array<Array<Tile>>
        )
    }


    override fun getNumberOfRows(): Int {
        return boardArray[0].size
    }

    override fun getNumberOfColumns(): Int {
        return boardArray.size
    }

    override fun getColorPieces(color: String): List<Piece> {
        val pieces = mutableListOf<Piece>()
        for (i in boardArray.indices) {
            for (j in 0 until boardArray[i].size) {
                if(boardArray[i][j].isOccupied() && boardArray[i][j].getPiece().getColor() == color) {
                    pieces.add(boardArray[i][j].getPiece())
                }
            }
        }
        return pieces
    }

    override fun getPositionFromPiece(piece: Piece): Position {
        for (i in boardArray.indices){
            for (j in 0 until boardArray[i].size) {
                if(boardArray[i][j].isOccupied() && boardArray[i][j].getPiece().getId() == piece.getId()) {
                    return Position(i,j)
                }
            }
        }
        throw Exception("Not found")
    }


}