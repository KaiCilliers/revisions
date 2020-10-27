package com.example.testzone.sleep.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.databinding.FragmentSleepDetailBinding
import com.example.testzone.navigateTo
import com.example.testzone.sleep.database.SleepDatabase
import com.example.testzone.subscribe

class DetailFragment : Fragment() {
    private val application by lazy { requireActivity().application }
    private val arguments by lazy { DetailFragmentArgs.fromBundle(requireArguments()) }
    private val dataSource by lazy { SleepDatabase.instance(application).sleepDao }
    private val factory by lazy { DetailViewModelFactory(
        arguments.sleepNightKey, dataSource
    )}
    private val viewModel by lazy { ViewModelProvider(this, factory).get(DetailViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSleepDetailBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.navigateToTracker.subscribe(viewLifecycleOwner) {
            if(it)
                requireView().navigateTo(
                    DetailFragmentDirections.actionDetailFragmentToTrackerFragment()
                )
            viewModel.doneNavigating()
        }
        return binding.root
    }
}