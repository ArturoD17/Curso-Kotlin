package example.myapp

// Subclase Plecostomus que implementa AquariumFish e interfaz FishAction
class Plecostomus : AquariumFish() {
    override val color = "gold"

    override fun eat() {
        println("eat algae")
    }
}
