package com.example.testzone.sleep.tracker

import android.app.Application
import androidx.lifecycle.*
import com.example.testzone.sleep.database.SleepDao
import com.example.testzone.sleep.database.SleepNightEntity
import com.example.testzone.sleep.formatNights
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrackerViewModel(
    val db: SleepDao,
    application: Application
) : AndroidViewModel(application) {
    private val _navigateToQuality = MutableLiveData<SleepNightEntity>()
    val navigateToQuality: LiveData<SleepNightEntity>
        get() = _navigateToQuality

    private var tonight = MutableLiveData<SleepNightEntity?>()
    private val nights = db.all()
    val nightsString = Transformations.map(nights) {
        formatNights(it, application.resources)
    }

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
        if (night?.endTimeMilli != night?.startTimeMilli)
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

    fun onStopTracking() {
        viewModelScope.launch(Dispatchers.IO) {
            val oldNight = tonight.value ?: return@launch
            oldNight.endTimeMilli = System.currentTimeMillis()
            update(oldNight)
            _navigateToQuality.postValue(oldNight)
        }
    }

    fun onClear() {
        viewModelScope.launch(Dispatchers.IO) {
            clear()
            tonight.postValue(null)
        }
    }

    fun doneNavigating() {
        _navigateToQuality.value = null
    }

    private suspend fun clear() {
        db.clear()
    }

    private suspend fun update(night: SleepNightEntity) {
        db.update(night)
    }

    private suspend fun insert(night: SleepNightEntity) {
        db.insert(night)
    }
}