package com.example.testzone.guess.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.clickAction
import com.example.testzone.databinding.GuessGameFragmentBinding
import com.example.testzone.navigateTo
import com.example.testzone.subscribe
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
        binding.viewModel = viewModel
        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.eventGameFinished.subscribe(viewLifecycleOwner) {
            if (it) gameFinished()
        }
        return binding.root
    }

    private fun gameFinished() {
        requireContext().toast("Game has just finsihed")
        requireView().navigateTo(
            GuessGameFragmentDirections
                .actionGuessGameFragmentToGuessScoreFragment(
                    viewModel.score.value ?: 0
                )
        )
        viewModel.onGameFinishComplete()
    }
}