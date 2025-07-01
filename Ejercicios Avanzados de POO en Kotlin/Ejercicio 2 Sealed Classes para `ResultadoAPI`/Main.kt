fun procesarResultado(resultado: ResultadoAPI) {
    when (resultado) {
        is ResultadoAPI.Exito -> println("Éxito: ${resultado.datos}")
        is ResultadoAPI.Error -> println("Error: ${resultado.mensaje}")
        ResultadoAPI.Cargando -> println("Cargando datos, por favor espera...")
    }
}


fun main() {
    // Crear instancias de cada tipo de resultado
    val resultadoExito = ResultadoAPI.Exito("Datos recibidos correctamente.")
    val resultadoError = ResultadoAPI.Error("No se pudo conectar al servidor.")
    val resultadoCargando = ResultadoAPI.Cargando

    // Probar la función con cada caso
    procesarResultado(resultadoExito)
    procesarResultado(resultadoError)
    procesarResultado(resultadoCargando)
}
