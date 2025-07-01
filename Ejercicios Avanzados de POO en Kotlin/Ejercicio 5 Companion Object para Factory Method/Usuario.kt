class Usuario private constructor(val email: String) {

    companion object {
        fun crearDesdeEmail(email: String): Usuario? {
            return if ("@" in email) {
                Usuario(email)
            } else {
                null
            }
        }
    }
}
