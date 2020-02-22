package com.homyapplication.common.bases

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


fun ViewModel.launchDataLoad(
        execution: suspend CoroutineScope.() -> Unit,
        errorReturned: suspend CoroutineScope.(Throwable) -> Unit,
        finallyBlock: (suspend CoroutineScope.() -> Unit)? = null) {

    this.viewModelScope.launch {
        try {
            execution()
        } catch (e: Throwable) {
            errorReturned(e)
        } finally {
            finallyBlock?.invoke(this)
        }
    }
}

fun Context.showSnack(view: View, message: String) {
    val snack = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
    snack.setActionTextColor(Color.RED)
    snack.show()

}


fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}





