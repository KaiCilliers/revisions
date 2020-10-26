package com.example.testzone.guess.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {
    val score = MutableLiveData<Int>()
    val word = MutableLiveData<String>()
    private val wordList: MutableList<String> by lazy {
        mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
    }
    private fun resetList() {
        wordList.shuffle()
    }
    init {
        word.value = ""
        score.value = 0
        resetList()
        nextWord()
        Timber.e("GameViewModel created!")
    }

    private fun nextWord() {
        if(!wordList.isEmpty())
            word.value = wordList.removeAt(0)
    }
    fun onSkip(){
        score.value = (score.value)?.minus(1)
        nextWord()
    }
    fun onCorrect() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        Timber.e("GameViewModel destroyed!")
        super.onCleared()
    }
}