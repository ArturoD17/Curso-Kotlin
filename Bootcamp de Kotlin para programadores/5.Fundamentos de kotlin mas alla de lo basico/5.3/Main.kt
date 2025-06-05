fun main() {
    val book = Book("Cien Años de Soledad", "Gabriel García Márquez", 1967)

    // Obtener el Pair
    val (title, author) = book.getTitleAndAuthor()

    // Obtener el Triple
    val (t, a, y) = book.getBookInfo()

    // Imprimir la información completa
    println("Aquí está tu libro \"$t\" escrito por $a en $y.")
}
