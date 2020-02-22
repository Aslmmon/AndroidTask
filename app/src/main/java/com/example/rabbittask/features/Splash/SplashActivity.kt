package com.example.rabbittask.features.Splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rabbittask.R
import com.homyapplication.common.Navigation
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /**
         * Delay in Splash to Navigate to Home Activity after ..
         */
        GlobalScope.launch {
            delay(3000)
            Navigation.goToHomeActivity(this@SplashActivity)
        }
    }
}
