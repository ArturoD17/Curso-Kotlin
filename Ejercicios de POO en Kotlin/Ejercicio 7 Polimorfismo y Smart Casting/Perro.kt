class Perro(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: ¡Guau guau!")
    }

    override fun moverse() {
        println("$nombre corre rápidamente.")
    }
}
