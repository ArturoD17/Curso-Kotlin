package com.example.extensions

fun String.hasSpaces() = indexOf(" ") != -1

fun AquariumPlant.isRed() = color == "red"

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}
