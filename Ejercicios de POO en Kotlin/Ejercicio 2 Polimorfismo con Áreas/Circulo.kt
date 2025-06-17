import kotlin.math.PI

class Circulo(nombre: String, val radio: Double) : FiguraGeometrica(nombre) {
    override fun calcularArea(): Double {
        return PI * radio * radio
    }
}
