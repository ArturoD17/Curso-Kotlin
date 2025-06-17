fun describirComportamiento(animal: Animal) {
    when (animal) {
        is Pajaro -> println("Este animal vuela alto.")
        is Perro -> println("Este animal es el mejor amigo del hombre.")
        else -> println("Este animal tiene un comportamiento interesante.")
    }
}
