package com.example.studenthealthy.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "registro_bienestar")
data class RegistroBienestar(
    @PrimaryKey val fecha: LocalDate,
    val aguaIngestaMl: Int,
    val horasSueno: Float,
    val estadoAnimo: Int,
    val nota: String? = null,
    val peso: Float? = null,
    val sexoHombre: Boolean? = null
)
