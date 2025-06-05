// Definición de un singleton
object GoldColor : FishColor {
    override val color = "gold"
}

// Interfaz usada por el singleton
interface FishColor {
    val color: String
}

// Enumeración con propiedad
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// Otra enumeración con propiedad y uso de nombre y ordinal
enum class Direction(val degrees: Int) {
    NORTH(0),
    SOUTH(180),
    EAST(90),
    WEST(270)
}

fun main() {
    // Uso del singleton
    println("Singleton GoldColor color: ${GoldColor.color}")

    // Uso de la enumeración Color
    println("Color RED tiene código RGB: ${Color.RED.rgb}")
    println("Color GREEN tiene código RGB: ${Color.GREEN.rgb}")

    // Uso de la enumeración Direction
    println("Nombre de la dirección EAST: ${Direction.EAST.name}")
    println("Ordinal de la dirección EAST: ${Direction.EAST.ordinal}")
    println("Grados de la dirección EAST: ${Direction.EAST.degrees}")
}


