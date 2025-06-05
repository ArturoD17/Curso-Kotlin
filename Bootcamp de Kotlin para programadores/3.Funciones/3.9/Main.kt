fun main(args: Array<String>) {
    var fortune: String
    for (i in 1..10) {
        val birthday = getBirthday()
        fortune = getFortune(birthday)
        println("\nTu fortuna es: $fortune")
        if (fortune.contains("Tómatelo con calma")) break
    }
}

fun getBirthday(): Int {
    print("Ingresa tu fecha de nacimiento (día del mes): ")
    val input = readLine()
    return input?.toIntOrNull() ?: 1
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf(
        "¡Tendrás un gran día!",
        "Las cosas te irán bien hoy.",
        "Disfruta de un maravilloso día de éxito.",
        "Sé humilde y todo saldrá bien.",
        "Hoy es un buen día para ejercer la moderación.",
        "¡Tómatelo con calma y disfruta la vida!",
        "Atesora a tus amigos porque son tu mayor fortuna."
    )

    return when {
        birthday == 28 || birthday == 31 -> "¡Hoy es tu día especial! Espera lo inesperado."
        birthday in 1..7 -> "Comienza fuerte la semana y mantén el impulso."
        else -> fortunes[birthday % fortunes.size]
    }
}
