// Clase base con función polimórfica
open class FiguraGeometrica(val nombre: String) {
    open fun calcularArea(): Double {
        return 0.0
    }

    fun imprimirNombre() {
        println("Soy una figura: $nombre")
    }
}
