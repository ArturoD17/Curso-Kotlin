class NotificacionSMS(val telefono: String, val mensaje: String) : Notificacion() {
    override fun enviar() {
        println("Enviando SMS al número $telefono con mensaje: $mensaje")
    }
}
