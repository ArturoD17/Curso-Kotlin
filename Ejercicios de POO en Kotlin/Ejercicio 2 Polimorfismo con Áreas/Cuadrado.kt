class Cuadrado(nombre: String, val lado: Double) : FiguraGeometrica(nombre) {
    override fun calcularArea(): Double {
        return lado * lado
    }
}
