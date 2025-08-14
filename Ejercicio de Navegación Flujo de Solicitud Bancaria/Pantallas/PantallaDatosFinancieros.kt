package com.example.flujosolicitudbancaria.Pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun PantallaDatosFinancieros(
    onNavigateToNext: () -> Unit,
    onNavigateToMenu: () -> Unit
) {
    var ingresos by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // Botón de volver al menú
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = onNavigateToMenu) {
                Text("Volver al menú")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Paso 3: Datos Financieros",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de ingreso
        OutlinedTextField(
            value = ingresos,
            onValueChange = { nuevos ->
                ingresos = nuevos.filter { it.isDigit() || it == '.' }
            },
            label = { Text("Ingresos Mensuales") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón de siguiente
        Button(
            onClick = onNavigateToNext,
            enabled = ingresos.isNotBlank(),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Siguiente")
        }
    }
}
