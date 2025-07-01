sealed class ResultadoAPI {
    data class Exito(val datos: String) : ResultadoAPI()
    data class Error(val mensaje: String) : ResultadoAPI()
    object Cargando : ResultadoAPI()
}
