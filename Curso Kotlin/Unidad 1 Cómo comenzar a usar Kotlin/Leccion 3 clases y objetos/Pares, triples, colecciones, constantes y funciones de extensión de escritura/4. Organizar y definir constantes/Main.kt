// Constante de nivel superior: valor conocido en tiempo de compilación
const val ROCKS = 3

// Constante val asignada en tiempo de ejecución (ejemplo función simulada)
fun complexFunctionCall(): Int {
    println("Ejecutando función compleja")
    return 42
}

val value1 = complexFunctionCall() // OK
// const val CONSTANT1 = complexFunctionCall() // Error: no se puede asignar en tiempo de ejecución

// Objeto singleton que contiene constantes
object Constants {
    const val CONSTANT2 = "object constant"
}

// Clase con objeto complementario para constantes
class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}

fun main() {
    println("Constante de nivel superior ROCKS = $ROCKS")
    println("Valor val asignado en tiempo de ejecución: value1 = $value1")

    println("Constante en objeto singleton Constants.CONSTANT2 = ${Constants.CONSTANT2}")
    println("Constante en objeto complementario MyClass.CONSTANT3 = ${MyClass.CONSTANT3}")
}

