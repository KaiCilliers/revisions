package com.example.testzone

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_roll.clickAction { toast("Button clicked"); rollDice() }
        btn_count_up.clickAction { incrementLabel(tv_result) }
    }
    private fun rollDice() {
        tv_result.text = (1..6).random().toString()
    }
    private fun incrementLabel(tv: TextView) {
       if(tv.text.toString() == getString(R.string.label_hello_world)) {
           tv.text = "1"
       } else {
           when(val intVal = "${tv.text}".toInt()) {
               6 -> tv.text = "$intVal"
               else -> tv.text = "${intVal.inc()}"
           }
       }
    }
}

// Works, but we are can reuse this small code in a lot of places
//fun Button.buttonClickAction(action: () -> Unit) = setOnClickListener{action}
// Inline (which means no objects created, but direct calls instead) and workable on Views and not just Buttons
inline fun View.clickAction(crossinline action: () -> Unit) = setOnClickListener{action()}

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()