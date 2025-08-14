package com.example.holamundo.ejercicio

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
            Text("Ejercicio 1: Hola Mundo")
        }
        Button(
            onClick = { navController.navigate("ejercicio2") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 2: Tarjeta de Presentación")
        }

        Button(
            onClick = { navController.navigate("ejercicio3") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 3: Fila de Iconos de Redes Sociales")
        }
        Button(
            onClick = { navController.navigate("ejercicio4") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 4: Artículo de Blog Sencillo")
        }
        Button(
            onClick = { navController.navigate("ejercicio5") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 5: Composición de Fila y Columna")
        }
        Button(
            onClick = { navController.navigate("ejercicio6") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 6: Cuadrícula de 2x2")
        }
        Button(
            onClick = { navController.navigate("ejercicio7") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 7: Etiqueta de Producto")
        }

        Button(
            onClick = { navController.navigate("ejercicio8") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 8: Barra de Progreso Simple")
        }
        Button(
            onClick = { navController.navigate("ejercicio9") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 9: Tarjeta de Noticia")
        }
        Button(
            onClick = { navController.navigate("ejercicio10") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        ) {
            Text("Ejercicio 10: Pantalla de 'Login' Sencilla")
        }
    }
}
