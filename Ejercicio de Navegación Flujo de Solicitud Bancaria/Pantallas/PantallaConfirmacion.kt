package com.example.flujosolicitudbancaria.Pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaConfirmacion(
    onNavigateToNext: () -> Unit,
    onNavigateToMenu: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
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

        Text("Paso 4: Confirmación", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Por favor, revisa tus datos antes de finalizar la solicitud.")
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onNavigateToNext,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Finalizar y Enviar")
        }
    }
}
