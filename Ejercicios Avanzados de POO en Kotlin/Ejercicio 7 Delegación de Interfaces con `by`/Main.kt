fun main() {
    val impresoraLaser = ImpresoraLaser()
    val escanerCamaPlana = EscanerDeCamaPlana()

    val multifuncional = Multifuncional(impresoraLaser, escanerCamaPlana)

    // Probar impresión
    multifuncional.imprimir("Informe anual 2025")

    // Probar escaneo
    val textoEscaneado = multifuncional.escanear()
    println("Texto recibido tras escaneo: \"$textoEscaneado\"")
}


