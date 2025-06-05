fun main() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    // 1. Filtrar todos los curries y ordenarlos por longitud de cadena
    val curries = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println("Curries ordenados por longitud: $curries")

    // 2. Filtrar especias que empiezan con 'c' y terminan en 'e' (manera 1)
    val cAndE1 = spices.filter { it.startsWith("c") && it.endsWith("e") }
    println("Empiezan con 'c' y terminan en 'e' (forma 1): $cAndE1")

    // 2. Filtrar especias que empiezan con 'c' y terminan en 'e' (manera 2, usando funciones separadas)
    val startsWithC = spices.filter { it.startsWith("c") }
    val cAndE2 = startsWithC.filter { it.endsWith("e") }
    println("Empiezan con 'c' y terminan en 'e' (forma 2): $cAndE2")

    // 3. Tomar los primeros tres elementos y devolver los que comienzan con 'c'
    val firstThree = spices.take(3)
    val filteredFirstThree = firstThree.filter { it.startsWith("c") }
    println("Primeros tres que empiezan con 'c': $filteredFirstThree")
}
