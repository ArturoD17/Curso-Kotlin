package com.example.estadoeinteractividad.ejercicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuPantalla(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { navController.navigate("ejercicio1") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 1: Contador de Clics")
        }
        Button(
            onClick = { navController.navigate("ejercicio2") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 2: Mostrar y Ocultar un Mensaje")
        }
        Button(
            onClick = { navController.navigate("ejercicio3") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 3: Campo de Texto Interactivo")
        }
        Button(
            onClick = { navController.navigate("ejercicio4") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 4: App de Saludos")
        }
        Button(
            onClick = { navController.navigate("ejercicio5") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 5: Persistencia con `rememberSaveable`")
        }
        Button(
            onClick = { navController.navigate("ejercicio6") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 6: Cambiador de Color Aleatorio")
        }
        Button(
            onClick = { navController.navigate("ejercicio7") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 7: Validación Simple de Formulario")
        }
        Button(
            onClick = { navController.navigate("ejercicio8") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 8: Tarjeta Expandible")
        }
        Button(
            onClick = { navController.navigate("ejercicio9") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 9: Lista de Tareas Simple")
        }
        Button(
            onClick = { navController.navigate("ejercicio10") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 10: Contador de Caracteres")
        }
    }
}
