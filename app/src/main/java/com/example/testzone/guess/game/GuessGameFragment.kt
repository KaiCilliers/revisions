package com.example.testzone.guess.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.clickAction
import com.example.testzone.databinding.GuessGameFragmentBinding
import com.example.testzone.navigateTo
import com.example.testzone.toast

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
        binding.endGameButton.clickAction { onEndGame() }
        updateScoreText()
        updateWordText()
        return binding.root
    }

    private fun onEndGame() {
        gameFinished()
    }

    private fun gameFinished() {
        requireContext().toast("Game has just finsihed")
        requireView().navigateTo(
            GuessGameFragmentDirections
                .actionGuessGameFragmentToGuessScoreFragment(
                    viewModel.score.value ?: 0
                )
        )
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
        binding.wordText.text = viewModel.word.value
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.value.toString()
    }
}