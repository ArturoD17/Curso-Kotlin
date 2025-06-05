fun main() {
    // Paso 1: Trabajando con listas
    val list = listOf(1, 5, 3, 4)
    println("Suma de elementos en list: ${list.sum()}") // 13

    val list2 = listOf("a", "bbb", "cc")
    // println(list2.sum()) // Esto da error, no se puede sumar strings directamente

    // Sumar por longitud de cadenas usando sumBy (deprecated) o sumOf (recomendado)
    println("Suma de longitudes de strings: ${list2.sumOf { it.length }}") // 6

    // Recorrer la lista usando listIterator() e imprimir elementos separados por espacio
    for (s in list2.listIterator()) {
        print("$s ")
    }
    println() // salto de línea

    // Algunas funciones útiles en listas:
    println("Lista original: $list2")
    println("Lista invertida: ${list2.reversed()}")
    println("Lista contiene 'bbb'? ${list2.contains("bbb")}")
    println("Sublista de índices 0 a 2: ${list2.subList(0, 2)}")

    // Paso 2: Trabajando con mapas hash
    val scientific = hashMapOf(
        "guppy" to "poecilia reticulata",
        "catfish" to "corydoras",
        "zebra fish" to "danio rerio"
    )

    println("Nombre científico de guppy: ${scientific.get("guppy")}")
    println("Nombre científico de zebra fish: ${scientific["zebra fish"]}")

    // Clave no existente devuelve null
    println("Nombre científico de swordtail (no existe): ${scientific.get("swordtail")}")

    // getOrDefault
    println("Con getOrDefault: ${scientific.getOrDefault("swordtail", "sorry, I don't know")}")

    // getOrElse con lambda
    println("Con getOrElse: ${scientific.getOrElse("swordtail") { "sorry, I don't know" }}")

    // Mapa mutable: añadir y eliminar elementos
    val mutableScientific = mutableMapOf(
        "guppy" to "poecilia reticulata",
        "catfish" to "corydoras"
    )
    mutableScientific["swordtail"] = "xiphophorus hellerii" // añadir
    println("Mapa mutable tras añadir swordtail: $mutableScientific")

    mutableScientific.remove("catfish") // eliminar
    println("Mapa mutable tras eliminar catfish: $mutableScientific")
}

