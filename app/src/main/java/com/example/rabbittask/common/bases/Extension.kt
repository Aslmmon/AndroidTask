package com.homyapplication.common.bases

import android.app.AlertDialog
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder
import com.homyapplication.common.Constants

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


//fun Throwable?.toErrorBody(): String {
//    when (this) {
//        is SocketTimeoutException -> " Check Your Network Connection , Try Again later "
//        is ConnectException -> " Check Your Network Connection , Try Again later "
//        is UnknownHostException -> message.toString() + " Try again later "
//        is HttpException -> {
//            val errorBodyResponse = response()?.errorBody()?.string()
//            val gson = GsonBuilder().create()
//            val error = gson.fromJson<ErrorResponse>(errorBodyResponse, ErrorResponse::class.java)
//            when (error.httpCode) {
//                422 -> {
//                    val mobileError = error.error.message.mobile?.get(0)
//                    val passwordError = error.error.message.password?.get(0)
//                    var nameError = error.error.message.name?.get(0)
//                    var emailError = error.error.message.email?.get(0)
//                    nameError?.let { nameError -> return nameError }
//                    mobileError?.let { mobileError -> return mobileError }
//                    passwordError?.let { passwordError -> return passwordError }
//                    emailError?.let { email -> return email }
//                }
//                400 -> {
//                    val bodyError = error.error.message.body?.get(0)
//                    return bodyError.toString()
//                }
//                401 -> {
//                    // unAuthenticated
//                    val bodyError = error.error.message.body?.get(0)
//                    return bodyError.toString()
//                }
//                403 -> {
//                    // unAuthroized
//                    val bodyError = error.error.message.body?.get(0)
//                    return bodyError.toString()
//
//                }
//            }
//        }
//    }
//    return this?.message.toString()
//}



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





