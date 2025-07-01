// Devuelve coordenadas X e Y como Pair
fun obtenerCoordenadas(): Pair<Int, Int> {
    return Pair(10, 20)
}

// Devuelve datos de usuario: nombre, edad y si está activo, como Triple
fun obtenerDatosUsuario(): Triple<String, Int, Boolean> {
    return Triple("Wellington", 50, true)
}


fun main() {
    // Desestructuración del Pair
    val (x, y) = obtenerCoordenadas()
    println("Coordenadas: X=$x, Y=$y")

    // Desestructuración del Triple
    val (nombre, edad, estaActivo) = obtenerDatosUsuario()
    println("Datos del usuario:")
    println("- Nombre: $nombre")
    println("- Edad: $edad")
    println("- Activo: $estaActivo")
}


