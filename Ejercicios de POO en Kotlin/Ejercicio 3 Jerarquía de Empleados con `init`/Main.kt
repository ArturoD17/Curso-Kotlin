fun main() {
    val gerente = Gerente("Ana", 45, 3000.0, 1000.0)
    val desarrollador = Desarrollador("Carlos", 30, 2500.0, "Kotlin")

    println("Salario de ${gerente.nombre}: ${gerente.calcularSalario()}")
    println("Salario de ${desarrollador.nombre}: ${desarrollador.calcularSalario()}")
}
