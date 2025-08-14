package com.example.studenthealthy

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.studenthealthy.data.AppDatabase
import com.example.studenthealthy.screens.ConfiguracionesScreen
import com.example.studenthealthy.screens.PanelResumenScreen
import com.example.studenthealthy.screens.RegistroScreen
import com.example.studenthealthy.viewmodel.BienestarViewModel
import com.example.studenthealthy.viewmodel.BienestarViewModelFactory

class MainActivity : ComponentActivity() {

    private val notificationId = 1001

    private lateinit var viewModel: BienestarViewModel

    private val permisosLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permisos ->
        val permisoNotificaciones = permisos[Manifest.permission.POST_NOTIFICATIONS] ?: false

        if (permisoNotificaciones || Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            crearCanalNotificacion()
            mostrarNotificacionConChequeoPermiso()
        } else {
            // Aquí puedes mostrar mensaje al usuario si quieres
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(applicationContext)
        val registroDao = db.registroBienestarDao()
        val factory = BienestarViewModelFactory(registroDao)
        viewModel = ViewModelProvider(this, factory).get(BienestarViewModel::class.java)

        pedirPermisosSegunVersion()

        setContent {
            MaterialTheme {
                MainScreen(viewModel)
            }
        }
    }

    private fun pedirPermisosSegunVersion() {
        val permisosNecesarios = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                permisosNecesarios.add(Manifest.permission.POST_NOTIFICATIONS)
            }
        }

        if (permisosNecesarios.isNotEmpty()) {
            permisosLauncher.launch(permisosNecesarios.toTypedArray())
        } else {
            crearCanalNotificacion()
            mostrarNotificacionConChequeoPermiso()
        }
    }

    private fun crearCanalNotificacion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "canalRecordatorios"
            val nombre = "Recordatorios de Bienestar"
            val descripcion = "Canal para notificaciones sin sonido ni vibración"
            val importancia = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(channelId, nombre, importancia).apply {
                description = descripcion
                setSound(null, null)      // Sin sonido
                enableVibration(false)    // Sin vibración
            }

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun mostrarNotificacionConChequeoPermiso() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                // No hay permiso, no mostramos la notificación
                return
            }
        }

        val builder = NotificationCompat.Builder(this, "canalRecordatorios")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Notificación")
            .setContentText("Hoy es tu dia de Salud y Bienestar ")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(notificationId, builder.build())
    }
}

enum class BottomNavItem(val title: String, val icon: ImageVector) {
    PanelResumen("Resumen", Icons.Filled.Home),
    Registro("Registro", Icons.Filled.Edit),
    Configuraciones("Configuración", Icons.Filled.Settings)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(viewModel: BienestarViewModel) {
    var selectedTab by remember { mutableStateOf(BottomNavItem.PanelResumen) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                BottomNavItem.values().forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        selected = selectedTab == item,
                        onClick = { selectedTab = item }
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                BottomNavItem.PanelResumen -> PanelResumenScreen(viewModel) {
                    // Acción para registrar nuevo día o navegar, aquí vacío
                }
                BottomNavItem.Registro -> RegistroScreen(viewModel) // Asumiendo que no necesita lambda
                BottomNavItem.Configuraciones -> ConfiguracionesScreen(viewModel) // Asumiendo que no necesita lambda
            }
        }
    }
}
