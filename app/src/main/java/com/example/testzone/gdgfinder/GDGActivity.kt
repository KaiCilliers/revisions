package com.example.testzone.gdgfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.example.testzone.R
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testzone.databinding.ActivityGDGBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GDGActivity : AppCompatActivity() {
    private val activityScope by lazy { CoroutineScope(Dispatchers.Default) }
    lateinit var binding: ActivityGDGBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
         this,
            R.layout.activity_g_d_g
        )
        delayedInit()
    }

    private fun delayedInit() {
        activityScope.launch {
            setupNavigation()
        }
    }

    /**
     * Called when the hamburger menu or back button are pressed on the Toolbar
     *
     * Delegate this to Navigation.
     */
    override fun onSupportNavigateUp() = navigateUp(
        findNavController(R.id.nav_host_gdg), binding.drawerLayoutGdg
    )

    /**
     * Setup Navigation for this Activity
     */
    private fun setupNavigation() {
        // first find the nav controller
        val navController = findNavController(
            R.id.nav_host_gdg
        )
        setSupportActionBar(binding.toolbarGdg)

        //then setup the action bar, tell it about the DrawerLayout
        setupActionBarWithNavController(
            navController,
            binding.drawerLayoutGdg
        )

        // finally setup the left drawer (called a NavigationView)
        binding.navViewGdg.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->
            val toolBar = supportActionBar ?: return@addOnDestinationChangedListener
            when(destination.id) {
                R.id.home -> {
                    toolBar.setDisplayShowTitleEnabled(false)
                    binding.imgHero.visibility = View.VISIBLE
                }
                else -> {
                    toolBar.setDisplayShowTitleEnabled(true)
                    binding.imgHero.visibility = View.GONE
                }
            }
        }
    }
}