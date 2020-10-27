package com.example.testzone.sleep.tracker

import android.app.Application
import androidx.lifecycle.*
import com.example.testzone.sleep.database.SleepDao
import com.example.testzone.sleep.database.SleepNightEntity
import com.example.testzone.sleep.formatNights
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class TrackerViewModel(
    val db: SleepDao,
    application: Application
) : AndroidViewModel(application) {
    private val _navigateToQuality = MutableLiveData<SleepNightEntity?>()
    val navigateToQuality: LiveData<SleepNightEntity?>
        get() = _navigateToQuality

    private val _showSnackBarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackBarEvent

    private var tonight = MutableLiveData<SleepNightEntity?>()
    val nights = db.all()
    val nightsString = Transformations.map(nights) {
        formatNights(it, application.resources)
    }

    val startButtonVisible = Transformations.map(tonight) {
        it == null
    }
    val stopButtonVisible = Transformations.map(tonight) {
        it != null
    }
    val clearButtonVisible = Transformations.map(nights) {
        it?.isNotEmpty()
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
            _showSnackBarEvent.postValue(true)
        }
    }

    fun doneNavigating() {
        _navigateToQuality.postValue(null)
    }
    fun doneShowingSnackBar() {
        _showSnackBarEvent.value = false
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