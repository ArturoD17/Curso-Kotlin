fun main() {
    var dirtyLevel = 19

    // Lambda simple
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

    // Función de orden superior con lambda
    dirtyLevel = updateDirty(dirtyLevel, waterFilter)
    println("After filter: $dirtyLevel")  // 9

    // Función con nombre
    dirtyLevel = updateDirty(dirtyLevel, ::increaseDirty)
    println("After increase: $dirtyLevel")  // 10

    // Usando lambda directamente como último parámetro
    dirtyLevel = updateDirty(dirtyLevel) { dirty -> dirty + 23 }
    println("After custom op: $dirtyLevel")  // 33
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun increaseDirty(start: Int): Int {
    return start + 1
}



