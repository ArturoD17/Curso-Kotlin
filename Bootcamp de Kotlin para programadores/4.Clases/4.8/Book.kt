open class Book(val title: String, val author: String) {
    private var currentPage: Int = 0

    open fun readPage() {
        currentPage += 1
        println("Has leído la página $currentPage del libro \"$title\" de $author.")
    }

    fun getCurrentPage(): Int {
        return currentPage
    }
}
