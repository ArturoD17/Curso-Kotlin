package com.example.holamundo.ejercicio

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun Ejercicio10(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido",
            fontSize = 28.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Campo simulado para Usuario
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
                .padding(start = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Usuario", color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo simulado para Contraseña
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
                .padding(start = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Contraseña", color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Botón simulado Iniciar Sesión
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(Color(0xFF6200EE), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Iniciar Sesión", color = Color.White, fontSize = 16.sp)
        }
    }
}
