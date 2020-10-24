package com.example.testzone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_about_me.*

class AboutMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        btn_done.clickAction { addNickname(); toggleVisibility(0) }
        tv_nickname.clickAction { toggleVisibility(-1) }
    }
    private fun addNickname(
        to: TextView = tv_nickname,
        source: EditText = et_nickname_edit) {
        to.text = source.text
    }
    private fun toggleVisibility(state: Int) {
        when(state) {
            in 0..Int.MAX_VALUE -> {
                et_nickname_edit.gone()
                tv_nickname.visible()
                btn_done.gone()
                et_nickname_edit.hideKeyboard()
            }
            else -> {
                et_nickname_edit.visible()
                et_nickname_edit.requestFocus()
                et_nickname_edit.showKeyboard()
                tv_nickname.gone()
                btn_done.visible()
            }
        }
    }
}