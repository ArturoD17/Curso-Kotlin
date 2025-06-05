class Game {
    val path = mutableListOf(Directions.START)
    val location = Location()

    val north = {
        path.add(Directions.NORTH)
        location.updateLocation(Directions.NORTH)
        true
    }
    val south = {
        path.add(Directions.SOUTH)
        location.updateLocation(Directions.SOUTH)
        true
    }
    val east = {
        path.add(Directions.EAST)
        location.updateLocation(Directions.EAST)
        true
    }
    val west = {
        path.add(Directions.WEST)
        location.updateLocation(Directions.WEST)
        true
    }

    val end = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()
        false
    }

    fun move(where: () -> Boolean): Boolean {
        val result = where()
        println("You are at: ${location.currentDescription()}")
        return result
    }

    fun makeMove(input: String?): Boolean {
        return when(input?.lowercase()) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}
