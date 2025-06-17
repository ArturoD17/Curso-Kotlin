fun main() {
    val perro = Perro("Firulais")
    val gato = Gato("Michi")
    val pajaro = Pajaro("Piolín")

    // Lista de tipo Animal
    val animales: List<Animal> = listOf(perro, gato, pajaro)

    for (animal in animales) {
        animal.hacerSonido()
        animal.moverse()
        println("-----------")
    }
}
