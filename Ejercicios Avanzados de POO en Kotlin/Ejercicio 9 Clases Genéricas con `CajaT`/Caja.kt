class Caja<T>(private val contenido: T?) {

    fun obtenerContenido(): T? {
        return contenido
    }

    fun estaVacia(): Boolean {
        return contenido == null
    }
}
