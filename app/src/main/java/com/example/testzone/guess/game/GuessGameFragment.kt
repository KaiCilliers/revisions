package com.example.testzone.guess.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testzone.databinding.GuessGameFragmentBinding

class GuessGameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GuessGameFragmentBinding.inflate(inflater)
        return binding.root
    }
}