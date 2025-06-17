class Producto(val codigo: String, val precio: Double) {

    init {
        if (precio < 0.0) {
            throw IllegalArgumentException("El precio no puede ser negativo.")
        }
    }

    // Constructor secundario: solo código, precio por defecto
    constructor(codigo: String) : this(codigo, 9.99)

    // Constructor secundario: sin parámetros
    constructor() : this("GEN-001", 0.99)

    fun mostrarDetalles() {
        println("Producto: Código = $codigo, Precio = $precio")
    }
}
