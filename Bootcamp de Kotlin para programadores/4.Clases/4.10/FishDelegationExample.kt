package spices

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Plecostomus(
    fishColor: FishColor = GoldColor
) : FishAction by PrintingFishAction("eat a lot of algae"),
    FishColor by fishColor
