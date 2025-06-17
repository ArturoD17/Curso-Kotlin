class Coche : Vehiculo() {
    override fun describir() {
        super.describir()  // Llama al método de la clase base
        println("Más específicamente, un coche de 4 ruedas.")
    }
}
