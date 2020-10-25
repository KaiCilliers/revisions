package com.example.testzone.guess.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testzone.databinding.GuessScoreFragmentBinding

class GuessScoreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GuessScoreFragmentBinding.inflate(inflater)
        return binding.root
    }
}