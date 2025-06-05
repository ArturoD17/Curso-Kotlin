package example.myapp

import java.lang.Math.PI

class TowerTank(
    override var height: Int,
    var diameter: Int
) : Aquarium(height = height, width = diameter, length = diameter) {

    override var volume: Int
        get() = (width / 2.0 * length / 2.0 * height * PI / 1000).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2.0 * length / 2.0)).toInt()
        }

    override var water = volume * 0.8
    override val shape = "cylinder"
}
