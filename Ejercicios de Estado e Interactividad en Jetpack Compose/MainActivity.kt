package com.example.estadoeinteractividad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.estadoeinteractividad.navigation.AppNavigation
import com.example.estadoeinteractividad.ui.theme.EstadoEInteractividadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstadoEInteractividadTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}
