package example.myapp.decor

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println(decoration1.equals(decoration2))  // false
    println(decoration3.equals(decoration2))  // true

    // Uso de desestructuración con Decoration2
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

    val (rock, wood, diver) = d5
    println(rock)   // crystal
    println(wood)   // wood
    println(diver)  // diver

    // Si no necesitas una propiedad, puedes omitirla con _
    val (onlyRock, _, onlyDiver) = d5
    println(onlyRock)  // crystal
    println(onlyDiver) // diver
}

fun main() {
    makeDecorations()
}


