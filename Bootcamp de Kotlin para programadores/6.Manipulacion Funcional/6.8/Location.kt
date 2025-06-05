class Location(val width: Int = 4, val height: Int = 4) {
    var x = 0
    var y = 0

    private val map = Array(width) { arrayOfNulls<String>(height) }

    init {
        for (i in 0 until width) {
            for (j in 0 until height) {
                map[i][j] = "Location ($i,$j)"
            }
        }
    }

    fun updateLocation(direction: Directions) {
        when (direction) {
            Directions.NORTH -> y = (y - 1).coerceAtLeast(0)
            Directions.SOUTH -> y = (y + 1).coerceAtMost(height - 1)
            Directions.EAST -> x = (x + 1).coerceAtMost(width - 1)
            Directions.WEST -> x = (x - 1).coerceAtLeast(0)
            else -> {}
        }
    }

    fun currentDescription(): String = map[x][y] ?: "Unknown location"
}
