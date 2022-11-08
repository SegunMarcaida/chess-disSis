package Board

import Piece
import Position.Position
import Tile.EmptyTile
import Tile.OccupiedTile
import Tile.Tile

fun RectangularBoard(boardWidth: Int, boardHeight:Int) =RectangularBoard(Array(boardWidth)  {Array(boardHeight){EmptyTile()}})

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

    override fun changeWithPiece(piece: Piece, position: Position): Board {
        //Because arrays are 0-7
        val auxBoardArray = boardArray
        auxBoardArray[position.getPosY()][position.getPosX()] = OccupiedTile(piece)
        return RectangularBoard(auxBoardArray)
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


    override fun getNumberOfRows(): Int {
        return boardArray[0].size
    }

    override fun changeToEmpty(position: Position): Board {
        val auxBoardArray = boardArray.clone()
        auxBoardArray[position.getPosY() ][position.getPosX()] = EmptyTile()
        return RectangularBoard(auxBoardArray)
    }

}