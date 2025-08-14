package com.example.estadoeinteractividad.ejercicio

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Ejercicio8(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TarjetaExpandible()

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
}

@Composable
fun TarjetaExpandible() {
    var expandido by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Color.Gray)
            .clickable { expandido = !expandido }
            .padding(16.dp)
            .animateContentSize()
    ) {
        Text(
            text = "Título de la tarjeta",
            style = MaterialTheme.typography.titleMedium
        )
        if (expandido) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Aquí está el contenido detallado que solo se ve cuando la tarjeta está expandida.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
