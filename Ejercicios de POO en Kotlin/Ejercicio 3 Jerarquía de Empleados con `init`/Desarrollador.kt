class Desarrollador(
    nombre: String,
    edad: Int,
    salarioBase: Double,
    val lenguaje: String
) : Empleado(nombre, edad, salarioBase)
