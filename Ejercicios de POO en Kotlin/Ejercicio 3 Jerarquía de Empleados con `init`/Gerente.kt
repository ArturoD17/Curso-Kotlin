class Gerente(
    nombre: String,
    edad: Int,
    salarioBase: Double,
    val bono: Double
) : Empleado(nombre, edad, salarioBase) {

    override fun calcularSalario(): Double {
        return salarioBase + bono
    }
}
