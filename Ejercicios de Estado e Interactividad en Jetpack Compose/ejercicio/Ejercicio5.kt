package com.example.estadoeinteractividad.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Ejercicio5(navController: NavController) {
    ContadorPersistente()

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
fun ContadorPersistente() {
    var contador by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Has hecho clic $contador veces (persistente)")
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { contador++ }) {
            Text("Haz clic")
        }
    }
}
