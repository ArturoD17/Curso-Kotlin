package spices

// Interfaz SpiceColor con propiedad color (String)
interface SpiceColor {
    val color: String
}

// Clase abstracta Spice implementa SpiceColor
abstract class Spice : SpiceColor {
    // color como String, valor por defecto
    override val color: String = "no color"

    abstract val levelOfSpiciness: String

    abstract fun prepareSpice()
}
