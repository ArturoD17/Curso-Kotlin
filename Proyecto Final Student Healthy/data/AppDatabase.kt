package com.example.studenthealthy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RegistroBienestar::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    // El DAO debe definirse con minúscula inicial para seguir convención Kotlin
    abstract fun registroBienestarDao(): RegistroBienestarDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // Si INSTANCE no es null, devuelve la instancia,
            // si no, crea la base de datos sincronizadamente
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "student_healthy_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
