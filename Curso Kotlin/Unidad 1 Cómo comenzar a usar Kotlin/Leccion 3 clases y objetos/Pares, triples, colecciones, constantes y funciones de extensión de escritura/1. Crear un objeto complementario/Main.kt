class Choice {
    companion object {
        var name: String = "lyric"
        fun showDescription(name: String) = println("My favorite $name")
    }
}

fun main() {
    println(Choice.name)             // Accede a la propiedad del companion object
    Choice.showDescription("pick")  // Llama al método del companion object
    Choice.showDescription("selection")
}

