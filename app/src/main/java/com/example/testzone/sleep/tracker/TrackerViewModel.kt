package com.example.testzone.sleep.tracker

import android.app.Application
import androidx.lifecycle.*
import com.example.testzone.sleep.database.SleepDao
import com.example.testzone.sleep.database.SleepNightEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrackerViewModel(
    val db: SleepDao,
    application: Application
) : AndroidViewModel(application) {
    private var tonight = MutableLiveData<SleepNightEntity?>()

    init {
        initTonight()
    }
    private fun initTonight() {
        viewModelScope.launch(Dispatchers.IO) {
            tonight.postValue(getTonightFromDatabase())
        }
    }

    private suspend fun getTonightFromDatabase(): SleepNightEntity? {
        var night = db.tonight()
        if(night?.endTimeMilli != night?.startTimeMilli)
            night = null
        return night
    }
    fun onStartTracking() {
        viewModelScope.launch(Dispatchers.IO) {
            val night = SleepNightEntity()
            insert(night)
            tonight.postValue(getTonightFromDatabase())
        }
    }
    private suspend fun insert(night: SleepNightEntity) {
        db.insert(night)
    }
}