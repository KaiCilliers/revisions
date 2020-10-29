package com.example.testzone.gdgfinder.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.testzone.databinding.FragmentGdgHomeBinding
import com.example.testzone.subscribe

class GdgHomeFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(GdgHomeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGdgHomeBinding.inflate(inflater)
        return binding.root
    }
}