package Board

import Piece
import Position.Position
import Tile.Tile

interface Board{

fun getTile(position: Position): Tile
fun putAt(position: Position, piece: Piece): Tile
fun inBounds(position: Position):Boolean
fun removePiece(position: Position):Piece
fun getPieces():List<Piece>
fun getPiece(piece: Piece):Position
}