fun main() {
    operacionesConPeces()
    variablesMutablesEInmutables()
    variablesNulas()
    listasConNulos()
    operadorElvis()
}

fun operacionesConPeces() {
    val pecesFinales = (((2 + 71) + 233) - 13)
    val acuariosNecesarios = pecesFinales.div(30).plus(if (pecesFinales % 30 > 0) 1 else 0)

    println("Peces finales: $pecesFinales")
    println("Acuarios necesarios: $acuariosNecesarios")
    println("Dato curioso: 2, 71, 233 y 13 son números de Fibonacci.")
}

fun variablesMutablesEInmutables() {
    var rainbowColor = "Rojo"
    println("rainbowColor inicial: $rainbowColor")
    rainbowColor = "Azul"
    println("rainbowColor modificado: $rainbowColor")

    val blackColor = "Negro"
    println("blackColor: $blackColor")
    // blackColor = "Gris" // Esto daría error si se descomenta
}

fun variablesNulas() {
    var rainbowColorNullable: String? = "Rojo"
    rainbowColorNullable = null
    println("rainbowColorNullable: $rainbowColorNullable")

    var greenColor: String? = null
    var blueColor = null as String?
    println("greenColor: $greenColor")
    println("blueColor: $blueColor")
}

fun listasConNulos() {
    val lista1 = listOf(null, null)
    val lista2 = listOf<String?>(null, null)
    val lista3: List<String>? = null

    println("Lista1: $lista1")
    println("Lista2: $lista2")
    println("Lista3 (nula): $lista3")
}

fun operadorElvis() {
    val nullTest: Int? = null
    val resultado = nullTest?.plus(1) ?: 0
    println("Resultado de nullTest con Elvis operator: $resultado")
}

