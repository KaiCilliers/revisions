package com.example.testzone.sleep.tracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.databinding.FragmentSleepTrackerBinding
import com.example.testzone.sleep.database.SleepDatabase

class TrackerFragment : Fragment() {
    private val application by lazy { requireNotNull(this.activity).application }
    private val dataSource by lazy { SleepDatabase.instance(application).sleepDao }
    private val factory by lazy { TrackerViewModelFactory(dataSource, application) }
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            factory
        ).get(TrackerViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSleepTrackerBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }
}