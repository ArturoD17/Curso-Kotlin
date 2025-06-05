import kotlin.random.Random

fun main() {
    // 1. Lambda que devuelve una tirada de dados entre 1 y 12
    val rollDice = { Random.nextInt(1, 13) }
    println("RollDice sin argumentos: ${rollDice()}")

    // 2. Lambda que toma el número de lados y devuelve la tirada
    val rollDiceWithSides = { sides: Int ->
        if (sides == 0) 0 else Random.nextInt(1, sides + 1)
    }
    println("RollDice con lados 6: ${rollDiceWithSides(6)}")
    println("RollDice con lados 0: ${rollDiceWithSides(0)}")

    // 3. Variable rollDice2 usando notación de tipo de función
    val rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0 else Random.nextInt(1, sides + 1)
    }
    println("RollDice2 con lados 10: ${rollDice2(10)}")

    // 4. Función gamePlay que toma una función para tirar dados y la imprime
    fun gamePlay(rollFunction: (Int) -> Int, sides: Int) {
        val result = rollFunction(sides)
        println("You rolled a $result on a $sides-sided dice")
    }

    // 5. Pasar rollDice2 como argumento a gamePlay
    gamePlay(rollDice2, 6)
    gamePlay(rollDice2, 20)
    gamePlay(rollDice2, 0)
}
