fun main() {
    val game = Game()

    println(game.path) // Imprime [START]

    game.north()
    game.east()
    game.south()
    game.west()
    game.end()

    println(game.path) // Imprime []
}
