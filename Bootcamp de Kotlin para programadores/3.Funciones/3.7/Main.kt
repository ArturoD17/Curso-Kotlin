fun main() {
    // Ejecutar el programa 10 veces o hasta que salga la fortuna deseada
    for (i in 1..10) {
        val fortune = getFortuneCookie()
        println("Tu fortuna es: $fortune")

        if (fortune == "¡Tómatelo con calma y disfruta la vida!") {
            break
        }
    }
}

fun getFortuneCookie(): String {
    val fortunes = listOf(
        "¡Tendrás un gran día!",
        "Las cosas te irán bien hoy.",
        "Disfruta de un maravilloso día de éxito.",
        "Sé humilde y todo saldrá bien.",
        "Hoy es un buen día para ejercer la moderación.",
        "¡Tómatelo con calma y disfruta la vida!",
        "Atesora a tus amigos porque son tu mayor fortuna."
    )

    print("Ingresa tu fecha de nacimiento: ")
    val birthdayInput = readLine()
    val birthday = birthdayInput?.toIntOrNull() ?: 1

    val index = birthday % fortunes.size
    return fortunes[index]
}
