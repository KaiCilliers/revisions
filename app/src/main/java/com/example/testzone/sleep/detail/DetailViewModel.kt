package com.example.testzone.sleep.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testzone.sleep.database.SleepDao
import com.example.testzone.sleep.database.SleepNightEntity

class DetailViewModel(
    private val key: Long = 0L,
    dataSource: SleepDao
) : ViewModel() {
    private val db = dataSource
    val night: LiveData<SleepNightEntity>
    init {
        night = db.nightLiveData(key)
    }
    private val _navigateToTracker = MutableLiveData<Boolean>()
    val navigateToTracker: LiveData<Boolean>
        get() = _navigateToTracker

    fun doneNavigating() {
        _navigateToTracker.postValue(false)
    }
    fun onClose() {
        _navigateToTracker.postValue(true)
    }
}