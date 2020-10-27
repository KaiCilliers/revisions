package com.example.testzone.sleep.quality

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.sleep.database.SleepDao
import java.lang.IllegalArgumentException

class QualityViewModelFactory(
    private val sleepNightKey: Long,
    private val dataSource: SleepDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QualityViewModel::class.java))
                return QualityViewModel(sleepNightKey, dataSource) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}