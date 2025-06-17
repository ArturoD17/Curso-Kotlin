class NotificacionPush(val dispositivoId: String, val mensaje: String) : Notificacion() {
    override fun enviar() {
        println("Enviando notificación push al dispositivo $dispositivoId con mensaje: $mensaje")
    }
}
