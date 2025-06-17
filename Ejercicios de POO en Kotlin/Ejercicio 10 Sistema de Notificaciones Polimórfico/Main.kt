fun main() {
    val email = NotificacionEmail("juan@mail.com", "Bienvenida", "Hola Juan, bienvenido a la plataforma.")
    val sms = NotificacionSMS("+1234567890", "Tu código es 1234")
    val push = NotificacionPush("device123", "Tienes una nueva alerta")

    val listaNotificaciones: List<Notificacion> = listOf(email, sms, push)

    enviarTodas(listaNotificaciones)
}

