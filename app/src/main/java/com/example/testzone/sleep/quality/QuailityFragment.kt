package com.example.testzone.sleep.quality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testzone.databinding.FragmentSleepQualityBinding
import com.example.testzone.navigateTo
import com.example.testzone.sleep.database.SleepDatabase
import com.example.testzone.subscribe
import timber.log.Timber

class QuailityFragment : Fragment() {
    private val application by lazy { requireNotNull(this.activity).application }
    private val arguments by lazy { QuailityFragmentArgs.fromBundle(requireArguments()) }
    private val dataSource by lazy { SleepDatabase.instance(application).sleepDao }
    private val factory by lazy {
        QualityViewModelFactory(arguments.sleepNightKey, dataSource)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(QualityViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSleepQualityBinding.inflate(inflater)
        binding.viewModel = viewModel
        viewModel.navigateToTracker.subscribe(this) {
            if (it)
                requireView().navigateTo(
                    QuailityFragmentDirections.actionQuailityFragmentToTrackerFragment()
                )
            viewModel.doneNavigating()
        }
        return binding.root
    }
}