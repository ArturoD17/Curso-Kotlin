fun main() {
    recorrerArrayBasico()
    desafioNumerosDivisiblesPor7()
}

fun recorrerArrayBasico() {
    val numbers = arrayOf(11, 12, 13, 14, 15)
    val stringList = mutableListOf<String>()

    for (number in numbers) {
        stringList.add(number.toString())
    }

    println("Lista de cadenas: $stringList")
}

fun desafioNumerosDivisiblesPor7() {
    val listaDiv7 = mutableListOf<Int>()

    for (i in 0..100) {
        if (i % 7 == 0) {
            listaDiv7.add(i)
        }
    }

    println("Números entre 0 y 100 divisibles por 7: $listaDiv7")
}

