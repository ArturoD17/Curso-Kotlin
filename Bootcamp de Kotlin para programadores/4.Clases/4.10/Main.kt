package spices

fun main() {
    println("=== Prueba de Curry ===")
    val curry = Curry(levelOfSpiciness = "medium")
    println("Color of curry spice: ${curry.color}")
    curry.prepareSpice()

    println("\n=== Prueba de delegación Fish ===")
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}
