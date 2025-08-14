package com.example.estadoeinteractividad.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Ejercicio2(navController: NavController) {
    MensajeSecreto()

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
fun MensajeSecreto() {
    var mostrarMensaje by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            mostrarMensaje = !mostrarMensaje
        }) {
            Text("Revelar Secreto")
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (mostrarMensaje) {
            Text("🎉 Este es el mensaje secreto. ¡Felicidades! 🎉")
        }
    }
}
