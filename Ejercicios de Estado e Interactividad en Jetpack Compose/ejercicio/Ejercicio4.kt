package com.example.estadoeinteractividad.ejercicio


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Ejercicio4(navController: NavController) {
    AppDeSaludos()

    Spacer(modifier = Modifier.height(32.dp))

    Button(
        onClick = { navController.popBackStack() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Volver al menú")
    }
}

@Composable
fun AppDeSaludos() {
    var nombre by remember { mutableStateOf("") }
    var saludo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Ingresa tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { saludo = if (nombre.isNotBlank()) "¡Hola, $nombre!" else "" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Saludar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (saludo.isNotEmpty()) {
            Text(text = saludo, style = MaterialTheme.typography.headlineSmall)
        }
    }
}
