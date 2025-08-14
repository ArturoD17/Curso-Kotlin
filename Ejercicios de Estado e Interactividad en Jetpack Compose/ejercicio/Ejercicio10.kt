package com.example.estadoeinteractividad.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Ejercicio10(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al menú")
        }

        Spacer(modifier = Modifier.height(16.dp))

        EditorDeTextoConContador(modifier = Modifier.weight(1f))
    }
}

@Composable
fun EditorDeTextoConContador(modifier: Modifier = Modifier) {
    var texto by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        TextField(
            value = texto,
            onValueChange = {
                if (it.length <= 140) {
                    texto = it
                }
            },
            label = { Text("Escribe algo...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${texto.length} / 140",
            modifier = Modifier.align(Alignment.End),
            style = MaterialTheme.typography.bodySmall
        )
    }
}
