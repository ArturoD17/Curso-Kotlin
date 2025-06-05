fun main() {
    // Puedes probar distintas combinaciones aquí:
    println(whatShouldIDoToday("happy"))
    println(whatShouldIDoToday("sad", "lluvioso"))
    println(whatShouldIDoToday("feliz", "soleado", 35))
    println(whatShouldIDoToday("aburrido", "nublado", 10))
}

fun whatShouldIDoToday(mood: String, weather: String = "soleado", temperature: Int = 24): String {
    return when {
        mood == "feliz" && weather == "soleado" -> "Sal a caminar"
        mood == "triste" && weather == "lluvioso" && temperature < 10 -> "Toma chocolate caliente y mira una película"
        mood == "aburrido" && temperature > 30 -> "Ve a nadar"
        mood == "relajado" && weather == "nublado" -> "Lee un libro en casa"
        else -> "Quédate en casa y lee."
    }
}
