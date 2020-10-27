package com.example.testzone.sleep.tracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.R
import com.example.testzone.databinding.FragmentSleepTrackerBinding
import com.example.testzone.navigateTo
import com.example.testzone.sleep.SleepNightAdapter
import com.example.testzone.sleep.database.SleepDatabase
import com.example.testzone.snackbar
import com.example.testzone.subscribe
import timber.log.Timber

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
    private val adapter by lazy { SleepNightAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSleepTrackerBinding.inflate(inflater)
        binding.rcSleepList.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.navigateToQuality.subscribe(viewLifecycleOwner) {
            it?.let {
                requireView().navigateTo(
                    TrackerFragmentDirections.actionTrackerFragmentToQuailityFragment(
                        it.id
                    )
                )
                viewModel.doneNavigating()
            }
        }
        viewModel.showSnackBarEvent.subscribe(viewLifecycleOwner) {
            if (it) {
                snackbar(
                    getString(R.string.cleared_message),
                    requireActivity().findViewById(android.R.id.content)
                )
                viewModel.doneShowingSnackBar()
            }
        }
        viewModel.nights.subscribe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it)
            }
        }
        return binding.root
    }
}