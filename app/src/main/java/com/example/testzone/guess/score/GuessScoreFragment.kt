package com.example.testzone.guess.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.testzone.databinding.GuessScoreFragmentBinding

class GuessScoreFragment : Fragment() {
    private val factory: ScoreViewModelFactory by lazy {
        ScoreViewModelFactory(
            GuessScoreFragmentArgs.fromBundle(requireArguments()).score
        )
    }
    private val viewModel: ScoreViewModel by lazy {
        ViewModelProvider(this, factory)
            .get(ScoreViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GuessScoreFragmentBinding.inflate(inflater)
        binding.scoreText.text = viewModel.score.toString()
        return binding.root
    }
}