package com.example.testzone.trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.testzone.R
import com.example.testzone.databinding.ActivityTriviaBinding

class TriviaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding =
            DataBindingUtil.setContentView<ActivityTriviaBinding>(this, R.layout.activity_trivia)
        NavigationUI.setupActionBarWithNavController(
            this, findNavController(R.id.navHostFragment)
        )
        NavigationUI.setupWithNavController(
            binding.navDrawerView,
            findNavController(R.id.navHostFragment)
        )
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.navHostFragment).navigateUp()
}