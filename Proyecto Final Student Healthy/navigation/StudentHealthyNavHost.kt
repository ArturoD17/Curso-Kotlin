package com.example.studenthealthy.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studenthealthy.navigation.DashboardScreen
import com.example.studenthealthy.viewmodel.BienestarViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StudentHealthyNavHost(navController: NavHostController, viewModel: BienestarViewModel) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") {
            DashboardScreen(viewModel)
        }
    }
}