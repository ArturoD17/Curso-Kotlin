package com.example.holamundo.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Ejercicio5(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "🧑‍💻",
                fontSize = 40.sp // Tamaño aumentado para el emoji/avatar
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(text = "Wellington Diaz")
                Text(text = "En línea")
            }
        }
    }
}
