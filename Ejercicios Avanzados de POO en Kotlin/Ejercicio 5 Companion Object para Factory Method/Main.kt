
fun main() {
    val usuarioValido = Usuario.crearDesdeEmail("usuario@ejemplo.com")
    val usuarioInvalido = Usuario.crearDesdeEmail("usuarioEjemplo.com")

    // Comprobando el usuario válido
    if (usuarioValido != null) {
        println("Usuario válido creado con email: ${usuarioValido.email}")
    } else {
        println("Email inválido para crear usuario (usuarioValido)")
    }

    // Comprobando el usuario inválido
    if (usuarioInvalido != null) {
        println("Usuario válido creado con email: ${usuarioInvalido.email}")
    } else {
        println("Email inválido para crear usuario (usuarioInvalido)")
    }
}


