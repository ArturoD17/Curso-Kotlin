package com.example.holamundo.ejercicio

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun Ejercicio9(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Imagen simulada con Box de color
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Titular grande y negrita
        Text(
            text = "Innovaciones en Jetpack Compose",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Row con metadatos: autor y fecha
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Por Wellington Diaz")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "05 Ago 2025")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Resumen corto
        Text(
            text = "Jetpack Compose continúa revolucionando el desarrollo Android con una sintaxis declarativa, " +
                    "mejor rendimiento y una gran comunidad que impulsa su evolución constante."
        )
    }
}
