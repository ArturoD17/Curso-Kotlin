package com.example.studenthealthy.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studenthealthy.data.RegistroBienestar
import com.example.studenthealthy.data.RegistroBienestarDao
import kotlinx.coroutines.launch
import java.time.LocalDate

class BienestarViewModel(private val registroDao: RegistroBienestarDao) : ViewModel() {

    val aguaConsumidaMl = mutableStateOf(0)
    val horasDormidas = mutableStateOf(0f)
    val estadoAnimo = mutableStateOf(3)
    val notaDia = mutableStateOf("")
    val pesoKg = mutableStateOf(70f)
    val esHombre = mutableStateOf(true)

    fun registrarDatos(
        aguaMl: Int,
        horas: Float,
        animo: Int,
        nota: String,
        peso: Float,
        sexoHombre: Boolean,
        fecha: LocalDate
    ) {
        aguaConsumidaMl.value = aguaMl
        horasDormidas.value = horas
        estadoAnimo.value = animo
        notaDia.value = nota
        pesoKg.value = peso
        esHombre.value = sexoHombre

        viewModelScope.launch {
            val registro = RegistroBienestar(
                fecha = fecha,
                aguaIngestaMl = aguaMl,
                horasSueno = horas,
                estadoAnimo = animo,
                nota = nota,
                peso = peso,
                sexoHombre = sexoHombre
            )
            registroDao.insertarRegistro(registro)
        }
    }

    fun cargarRegistroPorFecha(fecha: LocalDate, onCargado: () -> Unit = {}) {
        viewModelScope.launch {
            val registro = registroDao.obtenerRegistroPorFecha(fecha)
            if (registro != null) {
                aguaConsumidaMl.value = registro.aguaIngestaMl
                horasDormidas.value = registro.horasSueno
                estadoAnimo.value = registro.estadoAnimo
                notaDia.value = registro.nota ?: ""
                pesoKg.value = registro.peso ?: 70f
                esHombre.value = registro.sexoHombre ?: true
            } else {
                aguaConsumidaMl.value = 0
                horasDormidas.value = 0f
                estadoAnimo.value = 3
                notaDia.value = ""
                pesoKg.value = 70f
                esHombre.value = true
            }
            onCargado()
        }
    }

    fun borrarDatosBienestar() {
        aguaConsumidaMl.value = 0
        horasDormidas.value = 0f
        estadoAnimo.value = 3
        notaDia.value = ""
        pesoKg.value = 70f
        esHombre.value = true

        viewModelScope.launch {
            registroDao.eliminarTodosRegistros()
        }
    }
}
