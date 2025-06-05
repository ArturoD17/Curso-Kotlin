package buildings

class Building<T : BaseBuildingMaterial>(private val material: T) {
    val baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded: Int
        get() = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        val materialName = material::class.simpleName
        println("Se requieren $actualMaterialsNeeded $materialName(s)")
    }
}
