package com.example.holamundo.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Ejercicio4(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Aprendiendo Jetpack Compose",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Jetpack Compose es una moderna herramienta para construir interfaces " +
                    "de usuario de forma declarativa en Android. Facilita el desarrollo " +
                    "de layouts complejos con menos código y mayor flexibilidad. " +
                    "En este artículo, exploraremos cómo usar componentes básicos como " +
                    "Column, Row y Text para crear aplicaciones limpias y eficientes."
        )
    }
}
