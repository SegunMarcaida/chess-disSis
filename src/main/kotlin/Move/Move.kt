package Move

import Position.Position

class Move(private val from: Position, private val to: Position) {

    fun getFrom():Position{
        return from
    }
    fun getTo():Position{
        return to
    }
}