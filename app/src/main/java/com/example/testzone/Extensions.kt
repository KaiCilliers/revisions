package com.example.testzone

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

inline fun View.clickAction(crossinline action: () -> Unit) = setOnClickListener{action()}
fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
fun TextView.clear(withText: String = "") { this.text = withText }
fun View.gone() { visibility = View.GONE }
fun View.invisible() { visibility = View.INVISIBLE }
fun View.visible() { visibility = View.VISIBLE }
fun ImageView.clear(imageResource: Int = R.drawable.empty_dice) { setImageResource(imageResource) }
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}
fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.RESULT_UNCHANGED_SHOWN)
}
fun View.navigateTo(destination: Int) = findNavController().navigate(destination)
fun View.navigateTo(destination: NavDirections) = findNavController().navigate(destination)
inline fun <T> LiveData<T>.subscribe(owner: LifecycleOwner, crossinline action: (T) -> Unit) =
    observe(owner, Observer { action(it) })