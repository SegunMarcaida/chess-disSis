package Board

import Piece
import Position.Position
import Tile.Tile

interface Board{

fun getTile(position: Position): Tile
fun putAt(position: Position, piece: Piece): Board
fun inBounds(position: Position):Boolean
fun removePiece(position: Position):Board
fun getPieces():List<Piece>
fun getPiece(piece: Piece):Position
fun changeWithPiece(piece: Piece, position: Position): Board
fun changeToEmpty(position: Position): Board

fun getNumberOfRows(): Int

}