package com.example.studenthealthy.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface RegistroBienestarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarRegistro(registro: RegistroBienestar)

    @Update
    suspend fun actualizarRegistro(registro: RegistroBienestar)

    @Query("SELECT * FROM registro_bienestar WHERE fecha = :fecha")
    suspend fun obtenerRegistroPorFecha(fecha: LocalDate): RegistroBienestar?

    @Query("SELECT * FROM registro_bienestar ORDER BY fecha DESC LIMIT :dias")
    fun obtenerRegistrosUltimosDias(dias: Int): Flow<List<RegistroBienestar>>

    @Query("DELETE FROM registro_bienestar")
    suspend fun eliminarTodosRegistros()
}
