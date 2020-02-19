package com.example.rabbittask

import android.app.Application
import android.content.Context
import com.example.splasho.di.viewModelModule
import com.floriaapp.vendor.common.di.networkModule
import com.floriaapp.vendor.common.di.repositoriesModule
import com.floriaapp.vendor.common.di.sharedPref
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TaskApp : Application() {

    companion object {
        lateinit var context: Context
        fun getAppContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TaskApp)
            androidLogger()
            modules(listOf(viewModelModule, networkModule, repositoriesModule, sharedPref))
        }
    }
}