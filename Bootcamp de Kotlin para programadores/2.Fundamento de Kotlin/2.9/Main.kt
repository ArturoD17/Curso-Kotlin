fun main() {
    gustosDePescado()
    validarNombreDePez()
}

fun gustosDePescado() {
    val trout = "trucha"
    val haddock = "abadejo"
    val snapper = "pargo"

    println("¿Te gusta comer $trout? Sí.")
    println("¿Te gusta comer $haddock? No.")
    println("¿Te gusta comer $snapper? Sí.")
}

fun validarNombreDePez() {
    val fishName = "salmon"

    when (fishName.length) {
        0 -> println("Error: nombre vacío.")
        in 3..12 -> println("Nombre del buen pez.")
        else -> println("Nombre del pez OK.")
    }
}
