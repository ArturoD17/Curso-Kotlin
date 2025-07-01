// Archivo Utilidades.kt
fun obtenerColor(prioridad: PrioridadTarea): String {
    return prioridad.colorHex
}
// Archivo Main.kt
fun main() {
    // Iterar sobre todas las prioridades
    for (prioridad in PrioridadTarea.values()) {
        println("Prioridad: ${prioridad.name}, Color: ${obtenerColor(prioridad)}")
    }
}
