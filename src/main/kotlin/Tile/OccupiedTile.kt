package Tile

import Piece

class OccupiedTile( private val piece: Piece): Tile {

    override fun isOccupied(): Boolean {
            return true
    }


    override fun getPiece(): Piece {
        return piece
    }
}