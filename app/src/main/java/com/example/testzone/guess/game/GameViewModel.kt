package com.example.testzone.guess.game

import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {
    var word = ""
    var score = 0
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
        resetList()
        nextWord()
        Timber.e("GameViewModel created!")
    }

    private fun nextWord() {
        if(!wordList.isEmpty())
            word = wordList.removeAt(0)
    }
    fun onSkip(){
        score--
        nextWord()
    }
    fun onCorrect() {
        score++
        nextWord()
    }

    override fun onCleared() {
        Timber.e("GameViewModel destroyed!")
        super.onCleared()
    }
}