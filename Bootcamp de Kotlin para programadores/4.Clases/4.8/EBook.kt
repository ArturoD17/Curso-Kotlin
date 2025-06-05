class EBook(title: String, author: String, val format: String = "texto") : Book(title, author) {
    private var wordCount: Int = 0

    override fun readPage() {
        wordCount += 250
        println("Has leído 250 palabras del eBook \"$title\" en formato $format.")
    }

    fun getWordCount(): Int {
        return wordCount
    }
}
