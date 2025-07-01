object GestorArchivos {

    fun crearArchivo(nombre: String, tamañoKB: Int): ElementoSistema.Archivo {
        return ElementoSistema.Archivo(nombre, tamañoKB)
    }

    fun crearDirectorio(nombre: String): ElementoSistema.Directorio {
        return ElementoSistema.Directorio(nombre)
    }
}
