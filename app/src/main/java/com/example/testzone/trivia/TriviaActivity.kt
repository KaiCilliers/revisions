package com.example.testzone.trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.testzone.R
import com.example.testzone.databinding.ActivityTriviaBinding

class TriviaActivity : AppCompatActivity() {
    private val binding: ActivityTriviaBinding by lazy {
        DataBindingUtil.setContentView<ActivityTriviaBinding>(this, R.layout.activity_trivia)
    }
    private val drawerLayout: DrawerLayout by lazy { binding.drawerLayout }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NavigationUI.setupWithNavController(
            binding.navDrawerView,
            findNavController(R.id.navHostFragment)
        )
        NavigationUI.setupActionBarWithNavController(
            this, findNavController(R.id.navHostFragment), drawerLayout
        )
    }

    override fun onSupportNavigateUp(): Boolean = NavigationUI.navigateUp(
        findNavController(R.id.navHostFragment), drawerLayout
    )
}