package buildings

// Función genérica separada, NO inline
fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) {
        println("edificio pequeño")
    } else {
        println("edificio grande")
    }
}
