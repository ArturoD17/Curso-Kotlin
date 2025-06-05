
// Función swim con valor predeterminado
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

// Funciones compactas para evaluar condiciones
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

// Función que puede usar una función como valor predeterminado
fun getDirtySensorReading(): Int {
    println("Reading sensor...")
    return (0..100).random()
}

// Función shouldChangeWater usando funciones compactas
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

// Función para obtener un día aleatorio (renombrada para evitar conflictos)
fun getRandomDay(): String {
    val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return days.random()
}

// Función que devuelve el alimento según el día (renombrada para evitar conflictos)
fun getFishFoodForDay(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

// Función principal para alimentar al pez y decidir si cambiar el agua
fun feedTheFish() {
    val day = getRandomDay()
    val food = getFishFoodForDay(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

// Función main
fun main() {
    // Pruebas de swim()
    swim()                        // usa el valor predeterminado "fast"
