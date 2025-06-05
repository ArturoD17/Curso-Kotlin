val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main() {
    // Paso 1: Filtrar decoraciones que empiezan con 'p'
    println("Paso 1:")
    println(decorations.filter { it[0] == 'p' })
    println("-----------")

    // Paso 2: Comparar filtro ansioso (eager) y perezoso (lazy)

    // Filtro eager: se evalúa inmediatamente
    val eager = decorations.filter { it[0] == 'p' }
    println("Paso 2:")
    println("eager: $eager")

    // Filtro lazy: se evalúa cuando se accede
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered") // Solo muestra la referencia
    val newList = filtered.toList() // Fuerza la evaluación
    println("new list: $newList")
    println("-----------")

    // Paso 3: Visualizar acceso con map() sobre una Sequence
    println("Paso 3:")
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap") // Referencia de la Sequence
    println("-----")
    println("first: ${lazyMap.first()}") // Solo accede al primer elemento
    println("-----")
    println("all: ${lazyMap.toList()}") // Accede a todos
    println("-----------")

    // Paso 4: Filtro antes de map con println
    println("Paso 4:")
    val lazyMap2 = decorations.asSequence()
        .filter { it[0] == 'p' }
        .map {
            println("access: $it")
            it
        }

    println("-----")
    println("filtered: ${lazyMap2.toList()}") // Solo accede a los filtrados
    println("-----------")

    // Paso 5: Uso de flatten() para aplanar una lista de listas
    println("Paso 5:")
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities) // lista de listas

    println("-----")
    println("Flat: ${mylist.flatten()}") // Aplana la lista
}
