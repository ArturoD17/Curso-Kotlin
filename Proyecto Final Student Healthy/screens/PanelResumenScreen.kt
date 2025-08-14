package com.example.studenthealthy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import com.example.studenthealthy.viewmodel.BienestarViewModel
import kotlin.math.roundToInt

@Composable
fun PanelResumenScreen(
    viewModel: BienestarViewModel,
    onRegistrarNuevoDia: () -> Unit
) {
    val vasoMl = 250

    // Estados observados del ViewModel
    val aguaConsumidaMl by viewModel.aguaConsumidaMl
    val horasDormidas by viewModel.horasDormidas
    val estadoAnimo by viewModel.estadoAnimo
    val notaDia by viewModel.notaDia
    val pesoKg by viewModel.pesoKg
    val esHombre by viewModel.esHombre

    // Meta diaria de agua
    val metaMl = if (esHombre) pesoKg * 35 else pesoKg * 31
    val progreso = (aguaConsumidaMl.toFloat() / metaMl).coerceIn(0f, 1f)

    val colorProgreso = when {
        progreso < 0.6f -> Color(0xFFFF5252)  // rojo
        progreso < 1f -> Color(0xFFFFA726)   // naranja
        else -> Color(0xFF4CAF50)            // verde
    }

    val animoEmojis = listOf("😞", "😐", "🙂", "😀", "🤩")
    val animoDescripcion = listOf("Muy triste", "Triste", "Neutral", "Feliz", "Muy feliz")

    // Estado para filtro de resumen
    var filtroSeleccionado by remember { mutableStateOf("Día") }

    // Simulación de resumen según filtro (día, semana, mes)
    val resumenTexto = when(filtroSeleccionado) {
        "Día" -> "Hoy has consumido ${aguaConsumidaMl / 1000f} L de agua, dormido $horasDormidas horas y tu estado de ánimo fue '${animoDescripcion.getOrElse(estadoAnimo -1) { "Neutral" }}'."
        "Semana" -> "En esta semana, promedio de agua: ${(aguaConsumidaMl / 1000f) * 1.1f} L, horas dormidas: ${horasDormidas * 1.05f}, ánimo generalmente '${animoDescripcion.getOrElse(estadoAnimo -1) { "Neutral" }}'."
        "Mes" -> "Este mes, has bebido un promedio de ${(aguaConsumidaMl / 1000f) * 1.2f} L diarios, dormido ${horasDormidas * 1.1f} horas, y estado de ánimo fue '${animoDescripcion.getOrElse(estadoAnimo -1) { "Neutral" }}'."
        else -> ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Resumen de Bienestar",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Filtro Día / Semana / Mes
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf("Día", "Semana", "Mes").forEach { filtro ->
                val seleccionado = filtro == filtroSeleccionado
                Text(
                    text = filtro,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (seleccionado) MaterialTheme.colorScheme.primary.copy(alpha = 0.3f) else Color.Transparent)
                        .clickable { filtroSeleccionado = filtro }
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    color = if (seleccionado) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    fontWeight = if (seleccionado) FontWeight.Bold else FontWeight.Normal,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar resumen simulado según filtro
        Text(
            text = resumenTexto,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Datos detallados actuales (como antes)
        Text(
            text = "Agua consumida: $aguaConsumidaMl ml (${String.format("%.2f", aguaConsumidaMl / 1000f)} L) | " +
                    "${(aguaConsumidaMl / vasoMl)} vasos",
            style = MaterialTheme.typography.titleMedium
        )

        LinearProgressIndicator(
            progress = progreso,
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .clip(RoundedCornerShape(6.dp)),
            color = colorProgreso
        )

        Text(
            text = "Meta diaria: ${metaMl.roundToInt()} ml (${String.format("%.2f", metaMl / 1000f)} L)",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        Text(
            text = "Horas dormidas: ${"%.1f".format(horasDormidas)} h",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Estado de ánimo: ${animoEmojis.getOrElse(estadoAnimo - 1) { "🙂" }} " +
                    "(${animoDescripcion.getOrElse(estadoAnimo - 1) { "Neutral" }})",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Peso: ${"%.1f".format(pesoKg)} kg (${String.format("%.1f", pesoKg * 2.20462f)} lbs)",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (notaDia.isNotBlank()) {
            Text(
                text = "Notas del día:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = notaDia,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }


    }
}
