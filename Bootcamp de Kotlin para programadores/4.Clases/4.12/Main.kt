// Definimos la clase de datos Spice
data class Spice(val name: String)

// Definimos la clase de datos SpiceContainer
data class SpiceContainer(val spice: Spice) {
    val label: String
        get() = "Spice: ${spice.name}"
}

fun main() {
    // Creamos algunas especias
    val cinnamon = Spice("Cinnamon")
    val paprika = Spice("Paprika")
    val turmeric = Spice("Turmeric")

    // Creamos contenedores con esas especias
    val container1 = SpiceContainer(cinnamon)
    val container2 = SpiceContainer(paprika)
    val container3 = SpiceContainer(turmeric)

    // Imprimimos las etiquetas de los contenedores
    println(container1.label)
    println(container2.label)
    println(container3.label)
}
