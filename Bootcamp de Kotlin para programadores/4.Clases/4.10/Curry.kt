package spices

class Curry(
    override val levelOfSpiciness: String,
    private val spiceColor: SpiceColor = YellowSpiceColor
) : Spice(), Grinder {

    // Devuelve el color de la instancia spiceColor
    override val color: String
        get() = spiceColor.color

    override fun prepareSpice() {
        grind()
        println("Prepare the curry spice with spiciness level: $levelOfSpiciness")
    }

    override fun grind() {
        println("Grinding the curry into fine powder...")
    }
}
