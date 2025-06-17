fun main() {
    // Usando el constructor primario
    val usuario1 = Usuario("jose123", "jose123@gmail.com")
    println("Usuario1: ${usuario1.username}, Email: ${usuario1.email}")

    // Usando el constructor secundario
    val usuario2 = Usuario("maria456")
    println("Usuario2: ${usuario2.username}, Email: ${usuario2.email}")

    // Usuario inválido (username vacío)
    try {
        val usuarioInvalido = Usuario("", "algo@correo.com")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    // Usuario inválido (email inválido)
    try {
        val usuarioInvalidoEmail = Usuario("carlos", "correoSinArroba")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

