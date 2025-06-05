fun main() {
    val game = Game()

    while (true) {
        print("Enter a direction: n/s/e/w: ")
        val input = readLine()
        val continueGame = game.makeMove(input)
        if (!continueGame) break
    }
}
