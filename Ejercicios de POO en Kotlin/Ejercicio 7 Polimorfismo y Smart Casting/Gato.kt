class Gato(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: ¡Miau!")
    }

    override fun moverse() {
        println("$nombre camina sigilosamente.")
    }
}
