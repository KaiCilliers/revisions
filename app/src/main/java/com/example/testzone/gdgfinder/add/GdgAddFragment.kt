package com.example.testzone.gdgfinder.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.testzone.R
import com.example.testzone.databinding.FragmentGdgAddBinding
import com.example.testzone.snackbar
import com.example.testzone.subscribe

class GdgAddFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(GdgAddViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGdgAddBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.showSnackBarEvent.subscribe(viewLifecycleOwner) {
            if (it == true) {
                snackbar(
                    getString(R.string.application_submitted),
                    requireView()
                )
                viewModel.doneShowingSnackbar()
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}