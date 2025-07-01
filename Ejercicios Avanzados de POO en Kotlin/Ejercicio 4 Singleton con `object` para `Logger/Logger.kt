object Logger {
    private val logs = mutableListOf<String>()

    fun log(mensaje: String) {
        logs.add(mensaje)
        println("LOG: $mensaje")
    }

    fun mostrarLogs() {
        println("\nHistorial de Logs:")
        for (mensaje in logs) {
            println(mensaje)
        }
    }
}
