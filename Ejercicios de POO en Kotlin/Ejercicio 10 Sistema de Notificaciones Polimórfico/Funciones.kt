fun enviarTodas(notificaciones: List<Notificacion>) {
    for (notificacion in notificaciones) {
        notificacion.enviar()
    }
}
