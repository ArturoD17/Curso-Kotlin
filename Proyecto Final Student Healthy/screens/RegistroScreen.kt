package com.example.studenthealthy.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import com.example.studenthealthy.viewmodel.BienestarViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegistroScreen(viewModel: BienestarViewModel) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val vasoMl = 250

    var fechaSeleccionada by remember { mutableStateOf(LocalDate.now()) }

    var vasosAgua by remember { mutableStateOf(0) }
    var horasDormidasLocal by remember { mutableStateOf(0f) }
    var estadoAnimoLocal by remember { mutableStateOf(3) }
    var notaDiaLocal by remember { mutableStateOf("") }
    var pesoKgLocal by remember { mutableStateOf(70f) }
    var esHombreLocal by remember { mutableStateOf(true) }

    val pesoLbs = pesoKgLocal * 2.20462f
    val metaMl = if (esHombreLocal) pesoKgLocal * 35 else pesoKgLocal * 31
    val metaLitros = metaMl / 1000f
    val metaVasos = (metaMl / vasoMl).roundToInt()

    val animoEmojis = listOf("😞", "😐", "🙂", "😀", "🤩")
    val animoDescripcion = listOf("Muy triste", "Triste", "Neutral", "Feliz", "Muy feliz")

    fun colorPorProgreso(progreso: Float): Color = when {
        progreso < 0.6f -> Color(0xFFFF5252)
        progreso < 1f -> Color(0xFFFFA726)
        else -> Color(0xFF4CAF50)
    }

    LaunchedEffect(fechaSeleccionada) {
        viewModel.cargarRegistroPorFecha(fechaSeleccionada) {
            vasosAgua = viewModel.aguaConsumidaMl.value / vasoMl
            horasDormidasLocal = viewModel.horasDormidas.value
            estadoAnimoLocal = viewModel.estadoAnimo.value
            notaDiaLocal = viewModel.notaDia.value
            pesoKgLocal = viewModel.pesoKg.value
            esHombreLocal = viewModel.esHombre.value
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro de Bienestar",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { fechaSeleccionada = fechaSeleccionada.minusDays(1) },
                modifier = Modifier.size(40.dp)
            ) { Text("<") }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = fechaSeleccionada.format(DateTimeFormatter.ofPattern("dd MMM yyyy")),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    val manana = fechaSeleccionada.plusDays(1)
                    if (manana <= LocalDate.now()) {
                        fechaSeleccionada = manana
                    }
                },
                modifier = Modifier.size(40.dp)
            ) { Text(">") }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Sexo", style = MaterialTheme.typography.titleMedium)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { esHombreLocal = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (esHombreLocal) MaterialTheme.colorScheme.primary else Color.LightGray
                ),
                modifier = Modifier.weight(1f).padding(4.dp)
            ) { Text("Hombre") }

            Button(
                onClick = { esHombreLocal = false },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!esHombreLocal) MaterialTheme.colorScheme.primary else Color.LightGray
                ),
                modifier = Modifier.weight(1f).padding(4.dp)
            ) { Text("Mujer") }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Peso: ${"%.1f".format(pesoKgLocal)} kg / ${"%.1f".format(pesoLbs)} lbs",
            style = MaterialTheme.typography.titleMedium
        )
        Slider(
            value = pesoKgLocal,
            onValueChange = { pesoKgLocal = it },
            valueRange = 30f..150f,
            steps = 120,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Agua consumida", style = MaterialTheme.typography.titleMedium)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { if (vasosAgua > 0) vasosAgua-- },
                modifier = Modifier.size(40.dp),
                contentPadding = PaddingValues(0.dp)
            ) { Text("-") }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                "${vasosAgua * vasoMl} ml  |  " +
                        "${"%.2f".format((vasosAgua * vasoMl) / 1000f)} L  |  " +
                        "$vasosAgua vasos",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { vasosAgua++ },
                modifier = Modifier.size(40.dp),
                contentPadding = PaddingValues(0.dp)
            ) { Text("+") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        val progreso = (vasosAgua * vasoMl).toFloat() / metaMl
        LinearProgressIndicator(
            progress = progreso.coerceIn(0f, 1f),
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(5.dp)),
            color = colorPorProgreso(progreso)
        )

        Text(
            "Meta diaria: ${metaMl.roundToInt()} ml (${String.format("%.2f", metaLitros)} L) | Aproximadamente $metaVasos vasos",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Horas dormidas", style = MaterialTheme.typography.titleMedium)
        Text("${"%.1f".format(horasDormidasLocal)} h")
        Slider(
            value = horasDormidasLocal,
            onValueChange = { horasDormidasLocal = it },
            valueRange = 0f..12f,
            steps = 11,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Estado de ánimo", style = MaterialTheme.typography.titleMedium)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            animoEmojis.forEachIndexed { index, emoji ->
                val selected = (index + 1) == estadoAnimoLocal
                Text(
                    text = emoji,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { estadoAnimoLocal = index + 1 }
                        .background(
                            if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.3f) else Color.Transparent,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(4.dp)
                )
            }
        }
        Text(
            text = animoDescripcion.getOrElse(estadoAnimoLocal - 1) { "" },
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = notaDiaLocal,
            onValueChange = { notaDiaLocal = it },
            label = { Text("Comentarios del día (opcional)") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.registrarDatos(
                    aguaMl = vasosAgua * vasoMl,
                    horas = horasDormidasLocal,
                    animo = estadoAnimoLocal,
                    nota = notaDiaLocal,
                    peso = pesoKgLocal,
                    sexoHombre = esHombreLocal,
                    fecha = fechaSeleccionada
                )
                Toast.makeText(context, "Registro guardado ✅", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Guardar Registro de Día")
        }
    }
}
