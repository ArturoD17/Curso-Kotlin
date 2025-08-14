package com.example.flujosolicitudbancaria.Pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaBienvenida(onNavigateToNext: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Inicia tu solicitud de tarjeta de crédito.")
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onNavigateToNext) {
            Text("Iniciar Solicitud")
        }
    }
}
