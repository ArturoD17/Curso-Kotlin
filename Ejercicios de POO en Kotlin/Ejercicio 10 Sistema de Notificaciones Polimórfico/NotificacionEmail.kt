class NotificacionEmail(val email: String, val asunto: String, val mensaje: String) : Notificacion() {
    override fun enviar() {
        println("Enviando email a $email con asunto '$asunto' y mensaje: $mensaje")
    }
}
