class Pajaro(nombre: String) : Animal(nombre) {
    override fun hacerSonido() {
        println("$nombre dice: ¡Pío pío!")
    }

    override fun moverse() {
        println("$nombre vuela por el cielo.")
    }
}
