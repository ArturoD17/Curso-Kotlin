package com.example.estadoeinteractividad.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Ejercicio7(navController: NavController) {
    FormularioSimple()

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
fun FormularioSimple() {
    var texto by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Ingresa texto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Acción del botón aquí */ },
            enabled = texto.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}
