package com.example.testzone.sleep.quality

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testzone.sleep.database.SleepDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QualityViewModel(
    private val sleepNightKey: Long = 0L,
    val db: SleepDao
) : ViewModel() {
    private val _navigateToTracker = MutableLiveData<Boolean>()
    val navigateToTracker: LiveData<Boolean>
        get() = _navigateToTracker
    fun doneNavigating() {
        _navigateToTracker.postValue(false)
    }
    fun onSetQuality(quality: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val tonight = db.night(sleepNightKey) ?: return@launch
            tonight.sleepQuality = quality
            db.update(tonight)
            _navigateToTracker.postValue(true)
        }
    }
}