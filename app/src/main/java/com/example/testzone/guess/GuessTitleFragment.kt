package com.example.testzone.guess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testzone.clickAction
import com.example.testzone.databinding.GuessTitleFragmentBinding
import com.example.testzone.navigateTo
import kotlinx.android.synthetic.main.guess_title_fragment.*

class GuessTitleFragment  : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GuessTitleFragmentBinding.inflate(inflater)
        binding.playGameButton.clickAction {
            requireView().navigateTo(GuessTitleFragmentDirections.actionGuessTitleFragmentToGuessGameFragment())
        }
        return binding.root
    }
}