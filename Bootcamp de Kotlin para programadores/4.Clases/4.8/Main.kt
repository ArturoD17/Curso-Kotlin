fun main() {
    val libroFisico = Book("Cien años de soledad", "Gabriel García Márquez")
    libroFisico.readPage()  // Aumenta currentPage en 1
    libroFisico.readPage()
    println("Página actual: ${libroFisico.getCurrentPage()}")

    val libroElectronico = EBook("1984", "George Orwell")
    libroElectronico.readPage()  // Aumenta wordCount en 250
    libroElectronico.readPage()
    println("Palabras leídas: ${libroElectronico.getWordCount()}")
}
