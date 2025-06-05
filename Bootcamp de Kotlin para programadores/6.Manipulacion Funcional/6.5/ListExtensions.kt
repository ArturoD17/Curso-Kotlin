// package extensions  // opcional

fun List<Int>.filterByLambda(predicate: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (element in this) {
        if (predicate(element) == 0) {
            result.add(element)
        }
    }
    return result
}
