package com.example.studenthealthy.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.studenthealthy.R

class RecordatorioReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val notification = NotificationCompat.Builder(context, "canal_bienestar")
            .setSmallIcon(R.drawable.ic_water) // usa tu icono o uno por defecto
            .setContentTitle("Recordatorio de Salud")
            .setContentText("¡Hora de beber agua!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        NotificationManagerCompat.from(context).notify(1, notification)
    }
}
