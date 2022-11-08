package Tile

import Piece

class EmptyTile() : Tile {
    override fun isOccupied(): Boolean {
            return false
    }

    override fun getPiece(): Piece {
        throw Exception("Tile Is Empty")
    }


}