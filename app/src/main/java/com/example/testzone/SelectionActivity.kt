package com.example.testzone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testzone.dessert.Dessert
import com.example.testzone.dessert.DessertActivity
import com.example.testzone.devbyte.DevByteActivity
import com.example.testzone.guess.GuessActivity
import com.example.testzone.mars.MarsActivity
import com.example.testzone.selection.SelectionAdapter
import com.example.testzone.simple.AboutMeActivity
import com.example.testzone.simple.ColorMyViewsActivity
import com.example.testzone.simple.MainActivity
import com.example.testzone.sleep.SleepActivity
import com.example.testzone.trivia.TriviaActivity
import kotlinx.android.synthetic.main.activity_selection.*

class SelectionActivity : AppCompatActivity() {
    private val adapter by lazy { SelectionAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        rc_seletion.adapter = adapter

        adapter.data = listOf(
            "MainActivity",
            "AboutMeActivity",
            "ColorMyViewsActivity",
            "TriviaActivity",
            "DessertActivity",
            "GuessActivity",
            "SleepActivity",
            "MarsActivity",
            "DevByteActivity"
        )

    }
}