fun main() {
    val producto1 = Producto("ABC123", 15.5)
    val producto2 = Producto("XYZ789") // Usa precio por defecto 9.99
    val producto3 = Producto()         // Usa código GEN-001 y precio 0.99

    producto1.mostrarDetalles()
    producto2.mostrarDetalles()
    producto3.mostrarDetalles()

    // Descomenta para probar excepción
    // val productoInvalido = Producto("NEG999", -10.0)
}
