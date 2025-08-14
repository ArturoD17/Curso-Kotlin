package com.example.studenthealthy.screens

import android.app.TimePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.work.*
import com.example.studenthealthy.viewmodel.BienestarViewModel
import com.example.studenthealthy.worker.RecordatorioWorker
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@Composable
fun ConfiguracionesScreen(viewModel: BienestarViewModel) {
    val context = LocalContext.current

    var recordatorioAgua by remember { mutableStateOf(false) }
    var recordatorioDormir by remember { mutableStateOf(false) }

    var horariosAgua by remember { mutableStateOf(listOf<Pair<Int, Int>>()) }

    var horarioDormirInicio by remember { mutableStateOf<Pair<Int, Int>?>(null) }
    var horarioDormirFin by remember { mutableStateOf<Pair<Int, Int>?>(null) }

    var mostrarDialogReset by remember { mutableStateOf(false) }
    var mostrarTimePickerForNewHorarioAgua by remember { mutableStateOf(false) }
    var mostrarTimePickerDormirInicio by remember { mutableStateOf(false) }
    var mostrarTimePickerDormirFin by remember { mutableStateOf(false) }

    var indiceEliminar by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(Unit) {
        val config = cargarConfiguraciones(context)
        recordatorioAgua = config["recordatorio_agua"] as Boolean
        recordatorioDormir = config["recordatorio_dormir"] as Boolean
        horariosAgua = config["horarios_agua"] as? List<Pair<Int, Int>> ?: emptyList()
        horarioDormirInicio = config["horario_dormir_inicio"] as? Pair<Int, Int>
        horarioDormirFin = config["horario_dormir_fin"] as? Pair<Int, Int>
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("Configuración", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Recordatorios",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        RecordatorioSwitch("Recordatorio para beber agua", recordatorioAgua) { recordatorioAgua = it }
        RecordatorioSwitch("Recordatorio alarma para dormir", recordatorioDormir) { recordatorioDormir = it }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Horarios para recordatorio de agua", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        horariosAgua.forEachIndexed { index, horario ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = formatHoraAMPM(horario.first, horario.second),
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { indiceEliminar = index }) {
                    Icon(Icons.Default.Delete, contentDescription = "Eliminar horario")
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { mostrarTimePickerForNewHorarioAgua = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar nuevo horario para agua")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Recordatorio para dormir (alarma)", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Inicio")
                Spacer(modifier = Modifier.height(4.dp))
                Button(onClick = { mostrarTimePickerDormirInicio = true }) {
                    Text(
                        text = horarioDormirInicio?.let { formatHoraAMPM(it.first, it.second) } ?: "--:--"
                    )
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Fin")
                Spacer(modifier = Modifier.height(4.dp))
                Button(onClick = { mostrarTimePickerDormirFin = true }) {
                    Text(
                        text = horarioDormirFin?.let { formatHoraAMPM(it.first, it.second) } ?: "--:--"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        val inicio = horarioDormirInicio
        val fin = horarioDormirFin

        if (inicio != null && fin != null) {
            val horasDormir = calcularHorasDormir(inicio, fin)
            Text("Duración estimada para dormir: $horasDormir horas")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                guardarConfiguraciones(
                    context,
                    recordatorioAgua,
                    recordatorioDormir,
                    horariosAgua,
                    horarioDormirInicio,
                    horarioDormirFin
                )
                Toast.makeText(context, "Configuración guardada", Toast.LENGTH_SHORT).show()

                val workManager = WorkManager.getInstance(context)
                // Cancelar trabajos anteriores
                workManager.cancelUniqueWork("recordatorios_agua")
                workManager.cancelUniqueWork("alarma_dormir_inicio")
                workManager.cancelUniqueWork("alarma_dormir_fin")

                if (recordatorioAgua) {
                    horariosAgua.forEachIndexed { index, horario ->
                        val delay = calcularDelay(horario.first, horario.second)
                        val workRequest = OneTimeWorkRequestBuilder<RecordatorioWorker>()
                            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
                            .setInputData(workDataOf("mensaje" to "¡Hora de beber agua!"))
                            .addTag("recordatorios_agua")
                            .build()
                        workManager.enqueueUniqueWork(
                            "recordatorio_agua_$index",
                            ExistingWorkPolicy.REPLACE,
                            workRequest
                        )
                    }
                }

                if (recordatorioDormir && inicio != null && fin != null) {
                    val delayInicio = calcularDelay(inicio.first, inicio.second)
                    val workRequestInicio = OneTimeWorkRequestBuilder<RecordatorioWorker>()
                        .setInitialDelay(delayInicio, TimeUnit.MILLISECONDS)
                        .setInputData(workDataOf("mensaje" to "Hora de dormir. ¡A descansar!"))
                        .build()
                    workManager.enqueueUniqueWork(
                        "alarma_dormir_inicio",
                        ExistingWorkPolicy.REPLACE,
                        workRequestInicio
                    )

                    val delayFin = calcularDelay(fin.first, fin.second)
                    val workRequestFin = OneTimeWorkRequestBuilder<RecordatorioWorker>()
                        .setInitialDelay(delayFin, TimeUnit.MILLISECONDS)
                        .setInputData(workDataOf("mensaje" to "Hora de despertar. ¡Buenos días!"))
                        .build()
                    workManager.enqueueUniqueWork(
                        "alarma_dormir_fin",
                        ExistingWorkPolicy.REPLACE,
                        workRequestFin
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar configuración")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
            onClick = { mostrarDialogReset = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Resetear datos", color = MaterialTheme.colorScheme.onError)
        }
    }

    // Dialogos TimePicker

    if (mostrarTimePickerForNewHorarioAgua) {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                if (!horariosAgua.contains(Pair(hour, minute))) {
                    horariosAgua = horariosAgua + Pair(hour, minute)
                    horariosAgua = horariosAgua.sortedWith(compareBy({ it.first }, { it.second }))
                }
                mostrarTimePickerForNewHorarioAgua = false
            },
            8, 0, false
        ).show()
    }

    if (mostrarTimePickerDormirInicio) {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                horarioDormirInicio = Pair(hour, minute)
                mostrarTimePickerDormirInicio = false
            },
            22, 0, false
        ).show()
    }

    if (mostrarTimePickerDormirFin) {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                horarioDormirFin = Pair(hour, minute)
                mostrarTimePickerDormirFin = false
            },
            6, 0, false
        ).show()
    }

    // Confirmar eliminación de horario de agua

    if (indiceEliminar != null) {
        ConfirmDialog(
            title = "Eliminar horario",
            message = "¿Quieres eliminar el horario ${
                formatHoraAMPM(
                    horariosAgua[indiceEliminar!!].first,
                    horariosAgua[indiceEliminar!!].second
                )
            }?",
            onConfirm = {
                horariosAgua = horariosAgua.toMutableList().also { it.removeAt(indiceEliminar!!) }
                indiceEliminar = null
            },
            onDismiss = { indiceEliminar = null }
        )
    }

    // Confirmar reseteo total

    if (mostrarDialogReset) {
        ConfirmDialog(
            title = "Confirmar reseteo",
            message = "¿Estás seguro de que quieres resetear todos los datos? Esta acción no se puede deshacer.",
            onConfirm = {
                viewModel.borrarDatosBienestar()
                mostrarDialogReset = false
                Toast.makeText(context, "Datos reseteados", Toast.LENGTH_SHORT).show()

                // Resetear variables locales y configuraciones guardadas
                recordatorioAgua = false
                recordatorioDormir = false
                horariosAgua = emptyList()
                horarioDormirInicio = null
                horarioDormirFin = null

                // Limpiar SharedPreferences
                val prefs = context.getSharedPreferences("configuraciones", Context.MODE_PRIVATE)
                prefs.edit().clear().apply()

                // Cancelar todos los recordatorios programados
                val workManager = WorkManager.getInstance(context)
                workManager.cancelUniqueWork("recordatorios_agua")
                workManager.cancelUniqueWork("alarma_dormir_inicio")
                workManager.cancelUniqueWork("alarma_dormir_fin")
            },
            onDismiss = { mostrarDialogReset = false }
        )
    }
}

@Composable
fun RecordatorioSwitch(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Switch(checked = checked, onCheckedChange = onCheckedChange)
        Spacer(modifier = Modifier.width(12.dp))
        Text(label)
    }
}

@Composable
fun ConfirmDialog(
    title: String,
    message: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties()
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 8.dp,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(title, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))
                Text(message, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) { Text("Cancelar") }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(onClick = onConfirm) { Text("Confirmar") }
                }
            }
        }
    }
}

fun formatHoraAMPM(hora: Int, minuto: Int): String {
    val calendar = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, hora)
        set(Calendar.MINUTE, minuto)
    }
    val format = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return format.format(calendar.time)
}

private fun calcularHorasDormir(inicio: Pair<Int, Int>, fin: Pair<Int, Int>): Int {
    val inicioMinutos = inicio.first * 60 + inicio.second
    val finMinutos = fin.first * 60 + fin.second
    val duracion =
        if (finMinutos > inicioMinutos) finMinutos - inicioMinutos else (24 * 60 - inicioMinutos) + finMinutos
    return duracion / 60
}

private fun guardarConfiguraciones(
    context: Context,
    recordatorioAgua: Boolean,
    recordatorioDormir: Boolean,
    horariosAgua: List<Pair<Int, Int>>,
    horarioDormirInicio: Pair<Int, Int>?,
    horarioDormirFin: Pair<Int, Int>?
) {
    val prefs = context.getSharedPreferences("configuraciones", Context.MODE_PRIVATE)
    with(prefs.edit()) {
        putBoolean("recordatorio_agua", recordatorioAgua)
        putBoolean("recordatorio_dormir", recordatorioDormir)
        putStringSet(
            "horarios_agua",
            horariosAgua.map { "${it.first}:${it.second}" }.toSet()
        )
        if (horarioDormirInicio != null) {
            putString("horario_dormir_inicio", "${horarioDormirInicio.first}:${horarioDormirInicio.second}")
        } else {
            remove("horario_dormir_inicio")
        }
        if (horarioDormirFin != null) {
            putString("horario_dormir_fin", "${horarioDormirFin.first}:${horarioDormirFin.second}")
        } else {
            remove("horario_dormir_fin")
        }
        apply()
    }
}

private fun cargarConfiguraciones(context: Context): Map<String, Any?> {
    val prefs = context.getSharedPreferences("configuraciones", Context.MODE_PRIVATE)
    val horariosSet = prefs.getStringSet("horarios_agua", emptySet()) ?: emptySet()
    val horarios = horariosSet.mapNotNull {
        val parts = it.split(":")
        if (parts.size == 2) {
            val h = parts[0].toIntOrNull()
            val m = parts[1].toIntOrNull()
            if (h != null && m != null) Pair(h, m) else null
        } else null
    }

    val dormirInicioString = prefs.getString("horario_dormir_inicio", null)
    val dormirFinString = prefs.getString("horario_dormir_fin", null)

    fun parseHoraMinuto(str: String?): Pair<Int, Int>? {
        if (str == null) return null
        val parts = str.split(":")
        if (parts.size != 2) return null
        val h = parts[0].toIntOrNull() ?: return null
        val m = parts[1].toIntOrNull() ?: return null
        return Pair(h, m)
    }

    return mapOf(
        "recordatorio_agua" to prefs.getBoolean("recordatorio_agua", false),
        "recordatorio_dormir" to prefs.getBoolean("recordatorio_dormir", false),
        "horarios_agua" to horarios.sortedWith(compareBy({ it.first }, { it.second })),
        "horario_dormir_inicio" to parseHoraMinuto(dormirInicioString),
        "horario_dormir_fin" to parseHoraMinuto(dormirFinString),
    )
}

private fun calcularDelay(hora: Int, minuto: Int): Long {
    val now = Calendar.getInstance()
    val alarmTime = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, hora)
        set(Calendar.MINUTE, minuto)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
    if (alarmTime.before(now)) {
        alarmTime.add(Calendar.DAY_OF_YEAR, 1)
    }
    return alarmTime.timeInMillis - now.timeInMillis
}
