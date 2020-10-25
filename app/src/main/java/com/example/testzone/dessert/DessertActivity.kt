package com.example.testzone.dessert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testzone.R
import timber.log.Timber

class DessertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.e("onCreate called")
        setContentView(R.layout.activity_dessert)
    }

    /** Lifecycle Methods **/
    override fun onStart() {
        super.onStart()
        Timber.e("onStart called")
    }

    override fun onResume() {
        super.onResume()
        Timber.e("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.e("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.e("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.e("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.e("onRestart Called")
    }
}