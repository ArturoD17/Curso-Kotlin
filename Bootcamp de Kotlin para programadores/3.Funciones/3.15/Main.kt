fun main() {
    // Obtener estado de ánimo del usuario
    val mood = getMoodFromUser()

    // Pedir clima y temperatura
    println("What is the weather like? (sunny, rainy, cloudy, snowy, etc.)")
    val weather = readLine() ?: "unknown"

    println("What is the temperature (in Celsius)?")
    val temperatureInput = readLine()
    val temperature = temperatureInput?.toIntOrNull() ?: 20  // Por defecto 20 si no es válido

    // Decidir qué hacer hoy
    val activity = whatShouldIDoToday(mood, weather, temperature)
    println("Based on your mood and weather, you should: $activity")

    // Programa de galletas de la suerte con repeat
    println("\nFortune cookies (repeat loop):")
    val fortunes = listOf(
        "You will have a great day",
        "Luck is on your side",
        "Be careful today",
        "New opportunities are coming",
        "Trust your instincts"
    )

    repeat(5) {
        println(fortunes.random())
        // break no funciona aquí, daría error de compilación si se usa
    }

    // Programa de galletas de la suerte con while
    println("\nFortune cookies (while loop):")
    var count = 0
    while (count < 5) {
        val fortune = fortunes.random()
        println(fortune)
        if (fortune.contains("careful")) {
            println("Warning detected, stopping early!")
            break
        }
        count++
    }
}

// Funciones para condiciones

fun isSadRainyZeroTemp(mood: String, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0

fun isVeryHot(temperature: Int) = temperature > 35

fun isSunnyAndHappy(mood: String, weather: String) =
    mood == "happy" && weather == "sunny"

// Función principal para decidir actividad

fun whatShouldIDoToday(mood: String, weather: String, temperature: Int): String {
    return when {
        isSadRainyZeroTemp(mood, weather, temperature) -> "stay in bed"
        isVeryHot(temperature) -> "go swimming"
        isSunnyAndHappy(mood, weather) -> "go for a walk"
        mood == "bored" && weather == "cloudy" -> "read a book"
        mood == "excited" && temperature < 20 -> "go hiking"
        weather == "snowy" -> "build a snowman"
        else -> "just relax"
    }
}

// Función para obtener estado de ánimo del usuario

fun getMoodFromUser(): String {
    println("How are you feeling today?")
    val mood = readLine() ?: ""
    return if (mood.isNotBlank()) mood.lowercase() else "neutral"
}
