class Curry(
    name: String,
    spiciness: String,
    color: SpiceColor = YellowSpiceColor
) : Spice(name, spiciness, color) {

    fun prepareSpice() {
        println("Preparing $name with spiciness $spiciness and color ${color.color}")
    }
}
