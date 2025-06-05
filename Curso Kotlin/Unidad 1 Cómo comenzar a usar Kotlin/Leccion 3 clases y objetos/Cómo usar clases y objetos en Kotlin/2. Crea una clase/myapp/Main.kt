package example.myapp

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()        // Muestra dimensiones por defecto
    myAquarium.height = 60        // Cambiamos una propiedad
    myAquarium.printSize()        // Muestra las nuevas dimensiones
}

fun main() {
    buildAquarium()
}



