/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.testzone.trivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.testzone.R
import com.example.testzone.clickAction
import com.example.testzone.databinding.FragmentGameWonBinding
import com.example.testzone.navigateTo
import com.example.testzone.toast
import kotlinx.android.synthetic.main.fragment_game_won.*


class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )

        binding.nextMatchButton.clickAction {
            nextMatchButton.navigateTo(R.id.action_gameWonFragment_to_gameFragment)
        }
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        requireContext().toast("NumCorrect: ${args.numCorrect}, NumQuestions: ${args.numQuestions}")
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun shareIntent(): Intent = Intent(Intent.ACTION_SEND).setType("text/plain")
        .putExtra(
            Intent.EXTRA_TEXT,
            getString(
                R.string.share_success_text,
                GameWonFragmentArgs.fromBundle(requireArguments()).numCorrect,
                GameWonFragmentArgs.fromBundle(requireArguments()).numQuestions
            )
        )

    private fun shareSuccess() = startActivity(shareIntent())

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        if (shareIntent().resolveActivity(requireActivity().packageManager) == null)
            menu.findItem(R.id.share).isVisible = false
    }
    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.share -> shareSuccess()
            R.id.share2 -> requireContext().toast("Dice One")
            R.id.share3 -> requireContext().toast("Dice Two")
            R.id.share4 -> requireContext().toast("Dice Three")
            R.id.share5 -> requireContext().toast("Dice Four")
        }
        return super.onOptionsItemSelected(item)
    }
}


// Showing the Share Menu Item Dynamically
//    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater?.inflate(R.menu.winner_menu, menu)
//        // check if the activity resolves
//        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
//            // hide the menu item if it doesn't resolve
//            menu?.findItem(R.id.share)?.setVisible(false)
//        }
//    }

// Sharing from the Menu
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item!!.itemId) {
//            R.id.share -> shareSuccess()
//        }
//        return super.onOptionsItemSelected(item)
//    }
