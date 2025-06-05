package com.example.extensions

fun main() {
    val text1 = "Hola Mundo"
    val text2 = "HolaMundo"
    println("$text1 has spaces? ${text1.hasSpaces()}")
    println("$text2 has spaces? ${text2.hasSpaces()}")

    val plant = GreenLeafyPlant(10)
    plant.print()

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()

    println("plant.isGreen = ${plant.isGreen}")
    println("aquariumPlant.isGreen = ${aquariumPlant.isGreen}")

    val nullablePlant: AquariumPlant? = null
    nullablePlant.pull()

    val anotherPlant: AquariumPlant? = AquariumPlant("red", 60)
    anotherPlant.pull()
}


