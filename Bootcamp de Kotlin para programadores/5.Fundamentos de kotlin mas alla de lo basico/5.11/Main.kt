import buildings.*

fun main() {
    val woodBuilding = Building(Wood())
    woodBuilding.build()  // Se requieren 400 Wood(s)

    val brickBuilding = Building(Brick())
    brickBuilding.build() // Se requieren 800 Brick(s)
}
