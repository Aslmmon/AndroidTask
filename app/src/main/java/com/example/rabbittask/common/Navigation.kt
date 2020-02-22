package com.homyapplication.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.rabbittask.features.MainActivity


object Navigation {

    fun goToHomeActivity(ctx: Context) {
        ctx.startActivity(Intent(ctx, MainActivity::class.java))
        (ctx as Activity).finish()
    }


}