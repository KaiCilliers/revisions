package com.example.testzone.trivia

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.testzone.R
import com.example.testzone.clickAction
import com.example.testzone.databinding.FragmentTitleBinding
import com.example.testzone.navigateTo
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Timber.e("onCreate called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTitleBinding.inflate(inflater)
        binding.apply {
            playButton.clickAction {
                findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            }
            btnRules.clickAction {
                btnRules.navigateTo(R.id.rulesFragment)
            }
            btnAbout.clickAction {
                btnAbout.navigateTo(R.id.aboutFragment)
            }
        }
        setHasOptionsMenu(true)
        Timber.e("onCreateView called")
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = NavigationUI
        .onNavDestinationSelected(item, requireView().findNavController()) ||
            super.onOptionsItemSelected(item)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.e("onAttach called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("onViewCreated called")
    }

    override fun onStart() {
        super.onStart()
        Timber.e("onStart called")
    }

    override fun onResume() {
        super.onResume()
        Timber.e("onResume called")
    }

    override fun onPause() {
        super.onPause()
        Timber.e("onPause called")
    }

    override fun onStop() {
        super.onStop()
        Timber.e("onStop called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.e("onDestroyView called")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.e("onDetach called")
    }
}