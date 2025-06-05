class Book(val title: String, val author: String) {

    fun canBorrow(currentBooksBorrowed: Int): Boolean {
        return currentBooksBorrowed < MAX_BOOKS
    }

    fun printUrl() {
        println("${Companion.BASE_URL}$title.html")
    }

    companion object {
        const val BASE_URL = "https://library.example.com/books/"
    }
}
