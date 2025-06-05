import kotlin.random.Random

class Puppy {

    fun playWithBook(book: Book) {
        if (book.pages <= 0) {
            println("El libro \"${book.title}\" ya no tiene páginas para romper.")
            return
        }
        val pagesToTear = Random.nextInt(1, 10).coerceAtMost(book.pages)
        book.tornPages(pagesToTear)
        println("El cachorro rompió $pagesToTear páginas. Quedan ${book.pages} páginas.")
    }
}
