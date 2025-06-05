fun main() {
    val book = Book(50, "Cien Años de Soledad", "Gabriel García Márquez")
    val puppy = Puppy()

    println("Peso inicial del libro: ${book.weight()} gramos")

    while (book.pages > 0) {
        puppy.playWithBook(book)
    }

    println("El libro \"${book.title}\" ya no tiene páginas. Peso final: ${book.weight()} gramos")
}
