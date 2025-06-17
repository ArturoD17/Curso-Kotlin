fun main() {
    val libro = Libro("Cien años de soledad", "Gabriel García Márquez", 417)
    val articulo = ArticuloDeRevista("La inteligencia artificial hoy", "Ana Pérez", "TechReview")

    println("Libro:")
    println("Título: ${libro.titulo}")
    println("Autor: ${libro.autor}")
    println("Páginas: ${libro.numeroPaginas}")
    println("-----------")

    println("Artículo de Revista:")
    println("Título: ${articulo.titulo}")
    println("Autor: ${articulo.autor}")
    println("Revista: ${articulo.nombreRevista}")
}
