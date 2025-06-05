package example.myapp

// Subclase Shark que implementa AquariumFish e interfaz FishAction
class Shark : AquariumFish() {
    override val color = "grey"

    override fun eat() {
        println("hunt and eat fish")
    }
}
