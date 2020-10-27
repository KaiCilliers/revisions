package com.example.testzone.sleep.tracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.sleep.database.SleepDao
import java.lang.IllegalArgumentException

class TrackerViewModelFactory(
    private val dataSource: SleepDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TrackerViewModel::class.java))
            return TrackerViewModel(dataSource, application) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}