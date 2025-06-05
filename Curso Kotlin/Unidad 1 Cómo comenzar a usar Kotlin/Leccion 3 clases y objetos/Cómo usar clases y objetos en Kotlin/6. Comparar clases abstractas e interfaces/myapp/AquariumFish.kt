package example.myapp

// Clase abstracta AquariumFish que implementa FishAction
abstract class AquariumFish : FishAction {
    abstract val color: String

    // Implementación por defecto de eat() para todos los peces
    override fun eat() = println("yum")
}


