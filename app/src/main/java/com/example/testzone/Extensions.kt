package com.example.testzone

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

inline fun View.clickAction(crossinline action: () -> Unit) = setOnClickListener{action()}
fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
fun TextView.clear(withText: String = "") { this.text = withText }
fun View.gone() { visibility = View.GONE }
fun ImageView.clear(imageResource: Int = R.drawable.empty_dice) { setImageResource(imageResource) }