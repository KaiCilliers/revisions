package com.example.testzone.guess.score

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ScoreViewModel(finalScore: Int) : ViewModel() {
    var score = finalScore
    init {
        Timber.e("Final score is $finalScore")
    }
}