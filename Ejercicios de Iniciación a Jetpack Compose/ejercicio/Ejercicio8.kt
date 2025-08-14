package com.example.holamundo.ejercicio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BarraDeProgreso(progreso: Float, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progreso.coerceIn(0f, 1f))
                .height(16.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun Ejercicio8(navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        BarraDeProgreso(progreso = 0.2f, navController = navController)
        Spacer(modifier = Modifier.height(8.dp))
        BarraDeProgreso(progreso = 0.5f, navController = navController)
        Spacer(modifier = Modifier.height(8.dp))
        BarraDeProgreso(progreso = 0.8f, navController = navController)
    }
}
