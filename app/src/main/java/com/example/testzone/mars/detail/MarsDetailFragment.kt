/*
 *  Copyright 2019, The Android Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.testzone.mars.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.testzone.databinding.FragmentDetailMarsBinding
import com.example.testzone.sleep.detail.DetailFragmentArgs

/**
 * This [Fragment] will show the detailed information about a selected piece of Mars real estate.
 */
class MarsDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentDetailMarsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        val marsProperty = MarsDetailFragmentArgs.fromBundle(
            requireArguments()
        ).selectedProperty
        val factory = MarsDetailViewModelFactory(marsProperty, application)
        binding.viewModel = ViewModelProvider(this, factory).get(MarsDetailViewModel::class.java)
        return binding.root
    }
}