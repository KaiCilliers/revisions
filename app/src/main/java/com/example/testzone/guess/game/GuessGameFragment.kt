package com.example.testzone.guess.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.clickAction
import com.example.testzone.databinding.GuessGameFragmentBinding

class GuessGameFragment : Fragment() {
    val viewModel: GameViewModel by lazy {
        ViewModelProvider(this).get(GameViewModel::class.java)
    }
    private lateinit var binding: GuessGameFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GuessGameFragmentBinding.inflate(inflater)
        binding.correctButton.clickAction { onCorrect() }
        binding.skipButton.clickAction { onSkip() }
        updateScoreText()
        updateWordText()
        return binding.root
    }
    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
        updateWordText()
        updateScoreText()
    }
    private fun updateWordText() {
        binding.wordText.text = viewModel.word
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }
}