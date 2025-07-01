// Archivo ExtensionesInt.kt

// Función de extensión para saber si un número es par
fun Int.esPar(): Boolean {
    return this % 2 == 0
}

// Función de extensión para calcular el cuadrado de un número
fun Int.cuadrado(): Int {
    return this * this
}
// Archivo Main.kt
fun main() {
    val numeroPar = 10
    val numeroImpar = 5

    // Usar las funciones de extensión
    println("$numeroPar es par? ${numeroPar.esPar()}")
    println("$numeroImpar es par? ${numeroImpar.esPar()}")

    println("El cuadrado de $numeroPar es: ${numeroPar.cuadrado()}")
    println("El cuadrado de $numeroImpar es: ${numeroImpar.cuadrado()}")
}
