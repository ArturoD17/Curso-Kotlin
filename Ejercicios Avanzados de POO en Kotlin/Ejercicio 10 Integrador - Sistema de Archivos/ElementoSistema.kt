sealed class ElementoSistema(open val nombre: String) {

    data class Archivo(
        override val nombre: String,
        val tamañoKB: Int
    ) : ElementoSistema(nombre)

    data class Directorio(
        override val nombre: String,
        val contenidos: MutableList<ElementoSistema> = mutableListOf()
    ) : ElementoSistema(nombre)
}
