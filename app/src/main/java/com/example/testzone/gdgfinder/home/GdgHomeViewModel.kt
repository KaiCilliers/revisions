package com.example.testzone.gdgfinder.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GdgHomeViewModel : ViewModel() {
    private val _navigateToSearch = MutableLiveData<Boolean>()
    val navigateToSearch: LiveData<Boolean>
        get() = _navigateToSearch

    fun fabClicked() {
        _navigateToSearch.value = true
    }

    fun navigated() {
        _navigateToSearch.value = false
    }
}