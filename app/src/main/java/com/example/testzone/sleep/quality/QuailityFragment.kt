package com.example.testzone.sleep.quality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testzone.databinding.FragmentSleepQualityBinding

class QuailityFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSleepQualityBinding.inflate(inflater)
        return binding.root
    }
}