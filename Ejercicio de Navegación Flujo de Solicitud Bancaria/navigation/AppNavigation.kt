package com.example.flujosolicitudbancaria.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flujosolicitudbancaria.Pantallas.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.BIENVENIDA
    ) {
        composable(AppRoutes.BIENVENIDA) {
            PantallaBienvenida(
                onNavigateToNext = {
                    navController.navigate(AppRoutes.DATOS_PERSONALES)
                }
            )
        }
        composable(AppRoutes.DATOS_PERSONALES) {
            PantallaDatosPersonales(
                onNavigateToNext = {
                    navController.navigate(AppRoutes.DATOS_FINANCIEROS)
                },
                onNavigateToMenu = {
                    navController.popBackStack(
                        route = AppRoutes.BIENVENIDA,
                        inclusive = false
                    )
                }
            )
        }
        composable(AppRoutes.DATOS_FINANCIEROS) {
            PantallaDatosFinancieros(
                onNavigateToNext = {
                    navController.navigate(AppRoutes.CONFIRMACION)
                },
                onNavigateToMenu = {
                    navController.popBackStack(
                        route = AppRoutes.BIENVENIDA,
                        inclusive = false
                    )
                }
            )
        }
        composable(AppRoutes.CONFIRMACION) {
            PantallaConfirmacion(
                onNavigateToNext = {
                    navController.navigate(AppRoutes.EXITO)
                },
                onNavigateToMenu = {
                    navController.popBackStack(
                        route = AppRoutes.BIENVENIDA,
                        inclusive = false
                    )
                }
            )
        }
        composable(AppRoutes.EXITO) {
            PantallaExito(
                onNavigateToHome = {
                    navController.popBackStack(
                        route = AppRoutes.BIENVENIDA,
                        inclusive = false
                    )
                }
            )
        }
    }
}
