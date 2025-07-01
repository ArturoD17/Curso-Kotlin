
interface Impresora {
    fun imprimir(documento: String)
}

interface Escaner {
    fun escanear(): String
}

class ImpresoraLaser : Impresora {
    override fun imprimir(documento: String) {
        println("Imprimiendo en impresora láser: $documento")
    }
}

class EscanerDeCamaPlana : Escaner {
    override fun escanear(): String {
        val resultado = "Documento escaneado en cama plana"
        println(resultado)
        return resultado
    }
}
