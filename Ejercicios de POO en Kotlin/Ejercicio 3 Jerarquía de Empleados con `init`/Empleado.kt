open class Empleado(
    val nombre: String,
    val edad: Int,
    val salarioBase: Double
) {
    init {
        println("Se ha registrado un nuevo empleado: $nombre")
    }

    open fun calcularSalario(): Double {
        return salarioBase
    }
}
