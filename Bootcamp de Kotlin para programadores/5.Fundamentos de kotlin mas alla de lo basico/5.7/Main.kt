fun main() {
    val book = Book("Macbeth", "William Shakespeare")

    val borrowed = 3
    val canBorrow = book.canBorrow(borrowed)
    println("¿Puede tomar prestado otro libro?: $canBorrow")

    book.printUrl()
}
