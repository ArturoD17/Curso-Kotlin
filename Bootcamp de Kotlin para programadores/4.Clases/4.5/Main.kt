fun main() {
    val spices = listOf(
        Spice("Paprika", "mild"),
        Spice("Cayenne", "hot"),
        Spice("Black Pepper", "medium"),
        Spice("Salt", "mild"),
        Spice("Ghost Pepper", "extreme"),
        Spice("Chili Powder", "spicy")
    )

    val spicySpices = spices.filter { it.heat > 3 }
    println("\nSpicy spices:")
    spicySpices.forEach { println("${it.name} with heat ${it.heat}") }

    val mildSpices = spices.filter { it.heat <= 3 }
    println("\nMild spices:")
    mildSpices.forEach { println("${it.name} with heat ${it.heat}") }

    val salt = makeSalt()
    println("\nCreated salt spice: ${salt.name} with spiciness '${salt.spiciness}' and heat ${salt.heat}")
}

fun makeSalt(): Spice = Spice("Salt")
