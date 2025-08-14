package com.example.estadoeinteractividad.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.estadoeinteractividad.ejercicio.*

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "menu") {

        composable("menu") {
            MenuPantalla(navController)
        }

        composable("ejercicio1") {
            Ejercicio1(navController)
        }
        composable("ejercicio2") {
            Ejercicio2(navController)
        }
        composable("ejercicio3") {
            Ejercicio3(navController)
        }
        composable("ejercicio4") {
            Ejercicio4(navController)
        }
        composable("ejercicio5") {
            Ejercicio5(navController)
        }
        composable("ejercicio6") {
            Ejercicio6(navController)
        }
        composable("ejercicio7") {
            Ejercicio7(navController)
        }
        composable("ejercicio8") {
            Ejercicio8(navController)
        }
        composable("ejercicio9") {
            Ejercicio9(navController)
        }
        composable("ejercicio10") {
            Ejercicio10(navController)
        }
    }
}
