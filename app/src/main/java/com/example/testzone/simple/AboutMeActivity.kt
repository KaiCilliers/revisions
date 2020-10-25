package com.example.testzone.simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.testzone.*
import com.example.testzone.databinding.ActivityAboutMeBinding

class AboutMeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutMeBinding
    private val name = MyMutableName("Pedro Balanco")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_about_me
        )
        binding.btnDone.clickAction { addNickname(); toggleVisibility(0) }
        binding.tvNickname.clickAction { toggleVisibility(-1) }
        binding.myMutableName = name
    }
    private fun addNickname(
        source: EditText = binding.etNicknameEdit) {
        name?.nickname = source.text.toString()
        binding.invalidateAll()
    }
    private fun toggleVisibility(state: Int) {
        when(state) {
            in 0..Int.MAX_VALUE -> {
                binding.apply {
                    etNicknameEdit.gone()
                    tvNickname.visible()
                    btnDone.gone()
                    etNicknameEdit.hideKeyboard()
                }
            }
            else -> {
                binding.apply {
                    etNicknameEdit.visible()
                    etNicknameEdit.requestFocus()
                    etNicknameEdit.showKeyboard()
                    tvNickname.gone()
                    btnDone.visible()
                }
            }
        }
    }
}