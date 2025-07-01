fun main() {
    val cajaString = Caja<String>("Hola Mundo")
    val cajaIntVacia = Caja<Int>(null)

    println("Contenido cajaString: ${cajaString.obtenerContenido()}")
    println("¿CajaString está vacía? ${cajaString.estaVacia()}")

    println("Contenido cajaIntVacia: ${cajaIntVacia.obtenerContenido()}")
    println("¿CajaIntVacia está vacía? ${cajaIntVacia.estaVacia()}")
}


