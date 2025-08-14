package com.example.estadoeinteractividad.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Ejercicio9(navController: NavController) {
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

        ListaDeTareas(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ListaDeTareas(modifier: Modifier = Modifier) {
    var nuevaTarea by remember { mutableStateOf("") }
    val tareas = remember { mutableStateListOf<String>() }

    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = nuevaTarea,
                onValueChange = { nuevaTarea = it },
                label = { Text("Nueva tarea") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (nuevaTarea.isNotBlank()) {
                        tareas.add(nuevaTarea.trim())
                        nuevaTarea = ""
                    }
                }
            ) {
                Text("Añadir")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(tareas) { tarea ->
                Text(
                    text = tarea,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}
