class Book(var pages: Int, val title: String, val author: String)

// Función de extensión para calcular el peso del libro
fun Book.weight(): Double = pages * 1.5

// Función de extensión para rasgar páginas
fun Book.tornPages(pagesTorn: Int) {
    pages = (pages - pagesTorn).coerceAtLeast(0)
}
