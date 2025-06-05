class Book(val title: String, val author: String, val year: Int) {

    // Devuelve título y autor como Pair
    fun getTitleAndAuthor(): Pair<String, String> {
        return Pair(title, author)
    }

    // Devuelve título, autor y año como Triple
    fun getBookInfo(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}
