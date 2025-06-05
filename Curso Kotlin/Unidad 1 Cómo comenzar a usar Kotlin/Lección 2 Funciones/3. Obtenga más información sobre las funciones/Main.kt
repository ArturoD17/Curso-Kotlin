import java.util.*    // Importa la clase Random

// Función que retorna un día aleatorio de la semana
fun randomDay() : String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// Función que retorna la comida del pez dependiendo del día
fun fishFood(day: String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"  // para Tuesday, Saturday u otros
    }
}

// Función que imprime el día y la comida correspondiente
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
}

// Función principal que inicia el programa
fun main(args: Array<String>) {
    feedTheFish()
}



