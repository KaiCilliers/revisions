package com.example.testzone.gdgfinder.search

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.testzone.databinding.FragmentGdgListBinding
import com.example.testzone.gdgfinder.search.list.GdgClickListener
import com.example.testzone.gdgfinder.search.list.GdgListAdapter

class GdgListFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(GdgListViewModel::class.java)
    }
    private val adapter by lazy {
        GdgListAdapter(GdgClickListener {
            val destination = Uri.parse(it.website)
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    destination
                )
            )
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGdgListBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.rcGdgChapterList.adapter = adapter

        viewModel

        return binding.root
    }
}