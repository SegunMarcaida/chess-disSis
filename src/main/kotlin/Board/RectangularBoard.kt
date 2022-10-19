package Board

import Piece
import Position.Position
import Tile.EmptyTile
import Tile.OccupiedTile
import Tile.Tile

class RectangularBoard(private val boardHeight: Int, private val boardWidth: Int) :Board {
    private val boardArray:Array<Array<Tile>> = Array(boardWidth)  {Array(boardHeight){EmptyTile()}}


    override fun getTile(position: Position): Tile {
        if (position.getPosX() >= 0 && position.getPosY() >= 0 && position.getPosX() <= boardArray.size && position.getPosY() <= boardArray[0].size){
           return boardArray[position.getPosX()][position.getPosY()]
        }
        throw Exception("position out of board")
    }


    override fun putAt( position: Position,piece: Piece): Tile {
        val oldTile = boardArray[position.getPosX()][position.getPosY()]
        boardArray[position.getPosX()][position.getPosY()] = OccupiedTile(piece)
        return oldTile
    }

    override fun inBounds(position: Position): Boolean {
        return (boardArray.size>= position.getPosX() && boardArray[0].size >= position.getPosY() )
    }

    override fun removePiece(position: Position): Piece {
        val oldPiece = getTile(position).getPiece()
        boardArray[position.getPosX()][position.getPosY()] = EmptyTile()
        return oldPiece
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


}