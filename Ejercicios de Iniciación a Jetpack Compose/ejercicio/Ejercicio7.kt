package com.example.holamundo.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ItemDeRecibo(nombreProducto: String, precio: String, navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = nombreProducto)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = precio)
    }
}

@Composable
fun Ejercicio7(navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        ItemDeRecibo(nombreProducto = "Café Americano", precio = "$2.50", navController = navController)
        ItemDeRecibo(nombreProducto = "Té Verde", precio = "$1.80", navController = navController)
        ItemDeRecibo(nombreProducto = "Pastel de Chocolate", precio = "$3.20", navController = navController)
    }
}
