package com.example.studenthealthy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studenthealthy.data.RegistroBienestarDao

class BienestarViewModelFactory(private val registroDao: RegistroBienestarDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BienestarViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BienestarViewModel(registroDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
