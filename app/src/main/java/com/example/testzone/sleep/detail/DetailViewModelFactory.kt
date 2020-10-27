package com.example.testzone.sleep.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.sleep.database.SleepDao
import java.lang.IllegalArgumentException

class DetailViewModelFactory(
    private val key: Long,
    private val dataSource: SleepDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java))
            return DetailViewModel(key, dataSource) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}