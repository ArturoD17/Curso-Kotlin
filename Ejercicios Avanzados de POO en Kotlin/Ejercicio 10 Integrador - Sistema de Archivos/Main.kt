fun ElementoSistema.Directorio.calcularTamañoTotal(): Int {
    var total = 0
    for (elemento in contenidos) {
        when (elemento) {
            is ElementoSistema.Archivo -> total += elemento.tamañoKB
            is ElementoSistema.Directorio -> total += elemento.calcularTamañoTotal()
        }
    }
    return total
}


fun main() {
    val raiz = GestorArchivos.crearDirectorio("Raiz")

    val doc1 = GestorArchivos.crearArchivo("Documento1.txt", 120)
    val doc2 = GestorArchivos.crearArchivo("Documento2.txt", 80)
    val imagen = GestorArchivos.crearArchivo("Foto.png", 200)

    val subDirectorio = GestorArchivos.crearDirectorio("SubDirectorio")
    val doc3 = GestorArchivos.crearArchivo("Documento3.txt", 50)

    // Agregar archivos a la raíz
    (raiz as ElementoSistema.Directorio).contenidos.add(doc1)
    raiz.contenidos.add(doc2)
    raiz.contenidos.add(imagen)
    raiz.contenidos.add(subDirectorio)

    // Agregar archivo a subdirectorio
    subDirectorio.contenidos.add(doc3)

    // Calcular tamaño total
    val tamañoTotal = raiz.calcularTamañoTotal()
    println("El tamaño total del directorio '${raiz.nombre}' es: $tamañoTotal KB")
}
