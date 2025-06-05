class Spice(val name: String, val spiciness: String = "mild") {

    val heat: Int
        get() = when (spiciness.lowercase()) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "hot" -> 7
            "extreme" -> 10
            else -> 0
        }

    init {
        println("Spice created: name = $name, spiciness = $spiciness, heat = $heat")
    }
}
