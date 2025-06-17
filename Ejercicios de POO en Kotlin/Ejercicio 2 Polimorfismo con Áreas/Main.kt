fun main() {
    val circulo = Circulo("Círculo", 5.0)
    val cuadrado = Cuadrado("Cuadrado", 4.0)

    // Lista de tipo FiguraGeometrica
    val figuras: List<FiguraGeometrica> = listOf(circulo, cuadrado)

    // Iterar sobre la lista y mostrar nombre y área
    for (figura in figuras) {
        figura.imprimirNombre()
        println("Área: ${figura.calcularArea()}")
        println("--------------")
    }
}
