fun main() {
    val hasHamlet = library.any { (_, books) ->
        books.contains("Hamlet")
    }

    println("¿Contiene 'Hamlet'?: $hasHamlet")

    val result = moreBooks.getOrPut("Romeo and Juliet") {
        "William Shakespeare"
    }

    println("Autor de 'Romeo and Juliet': $result")

    println("\nBiblioteca actualizada:")
    moreBooks.forEach { (title, author) ->
        println("• $title por $author")
    }
}
