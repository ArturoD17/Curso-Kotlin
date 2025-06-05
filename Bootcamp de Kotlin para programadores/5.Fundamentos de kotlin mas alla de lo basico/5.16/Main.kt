import buildings.*

fun main() {
    val woodBuilding = Building(Wood())
    val brickBuilding = Building(Brick())

    woodBuilding.build()
    brickBuilding.build()

    isSmallBuilding(woodBuilding)  // Imprime: edificio pequeño
    isSmallBuilding(brickBuilding) // Imprime: edificio grande
}
