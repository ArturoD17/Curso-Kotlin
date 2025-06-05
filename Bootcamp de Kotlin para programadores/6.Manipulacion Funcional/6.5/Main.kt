// import extensions.filterByLambda // si usas paquete

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    val divisibleBy3 = numbers.filterByLambda { it % 3 }
    println(divisibleBy3)  // [3, 6, 9, 0]
}
