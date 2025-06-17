class Usuario(val username: String, val email: String) {

    init {
        require(username.isNotBlank()) { "El nombre de usuario no puede estar vacío." }
        require("@" in email) { "El email debe contener '@'." }
    }

    // Constructor secundario que solo recibe el username
    constructor(username: String) : this(username, "$username@empresa.com")
}
