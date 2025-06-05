fun main() {
    // Ejemplo 1: Crear un par y acceder a sus partes
    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    // Ejemplo 2: Crear un Triple y mostrarlo
    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())

    // Ejemplo 3: Pares anidados
    val equipment2 = ("fish net" to "catching fish") to "equipment"
    println("${equipment2.first} is ${equipment2.second}")
    println("${equipment2.first.second}")

    // Ejemplo 4: Desestructurar un par
    val (tool, use) = equipment
    println("$tool is used for $use")

    // Ejemplo 5: Desestructurar un triple
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")

    // Ejemplo 6: Usar partition para separar peces de agua dulce y salada
    val fish = listOf("salmon", "carp", "tuna", "trout")
    fun isFreshWater(fish: String): Boolean {
        return fish == "carp" || fish == "trout"
    }

    val twoLists = fish.partition { isFreshWater(it) }
    println("freshwater: ${twoLists.first}")
    println("saltwater: ${twoLists.second}")
}

