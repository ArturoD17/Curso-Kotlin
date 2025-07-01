fun main() {
    // Crear dos instancias iguales
    val libro1 = Libro("Cien Años de Soledad", "Gabriel García Márquez", "978-0307474728")
    val libro2 = Libro("Cien Años de Soledad", "Gabriel García Márquez", "978-0307474728")

    // Comparar las dos instancias
    println("¿libro1 == libro2? ${libro1 == libro2}")  // Resultado: true

    // Imprimir una de las instancias (gracias a toString autogenerado)
    println("Contenido de libro1: $libro1")

    // Crear una copia cambiando solo el título
    val libro3 = libro1.copy(titulo = "El Amor en los Tiempos del Cólera")

    // Imprimir la nueva instancia
    println("Contenido de libro3: $libro3")
}
