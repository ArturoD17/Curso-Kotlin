package com.example.studenthealthy.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.studenthealthy.screens.ConfiguracionesScreen
import com.example.studenthealthy.screens.PanelResumenScreen
import com.example.studenthealthy.screens.RegistroScreen
import com.example.studenthealthy.viewmodel.BienestarViewModel

@Composable
fun DashboardScreen(viewModel: BienestarViewModel) {
    val navController = rememberNavController()
    val items = listOf(
        "registro" to "Registro",
        "resumen" to "Resumen",
        "configuraciones" to "Config"
    )

    var selectedRoute by remember { mutableStateOf("registro") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { (route, label) ->
                    val icon = when (route) {
                        "registro" -> Icons.Default.Edit
                        "resumen" -> Icons.Default.Home
                        "configuraciones" -> Icons.Default.Settings
                        else -> Icons.Default.Edit
                    }
                    NavigationBarItem(
                        selected = selectedRoute == route,
                        onClick = {
                            selectedRoute = route
                            navController.navigate(route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                            }
                        },
                        icon = { Icon(icon, contentDescription = label) },
                        label = { Text(label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "registro",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("registro") {
                RegistroScreen(viewModel)
                LaunchedEffect(Unit) { selectedRoute = "registro" }
            }
            composable("resumen") {
                PanelResumenScreen(
                    viewModel = viewModel,
                    onRegistrarNuevoDia = {
                        selectedRoute = "registro"
                        navController.navigate("registro") {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                        }
                    }
                )
                LaunchedEffect(Unit) { selectedRoute = "resumen" }
            }
            composable("configuraciones") {
                ConfiguracionesScreen(viewModel)
                LaunchedEffect(Unit) { selectedRoute = "configuraciones" }
            }
        }
    }
}
