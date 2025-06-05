import java.util.Calendar  // Importa la clase Calendar

fun main() {
    dayOfWeek()  // Llamada a la función
}

fun dayOfWeek() {
    println("¿Qué día es hoy?")

    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

    when (day) {
        Calendar.SUNDAY -> println("Hoy es domingo.")
        Calendar.MONDAY -> println("Hoy es lunes.")
        Calendar.TUESDAY -> println("Hoy es martes.")
        Calendar.WEDNESDAY -> println("Hoy es miércoles.")
        Calendar.THURSDAY -> println("Hoy es jueves.")
        Calendar.FRIDAY -> println("Hoy es viernes.")
        Calendar.SATURDAY -> println("Hoy es sábado.")
        else -> println("Día desconocido.")
    }
}
