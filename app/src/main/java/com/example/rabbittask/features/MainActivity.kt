package com.example.rabbittask.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rabbittask.R
import com.example.rabbittask.features.adapter.EventsAdapter
import com.example.rabbittask.features.adapter.HotSpotAdapter
import com.example.rabbittask.model.Event
import com.example.rabbittask.model.HotSpot
import com.sa90.materialarcmenu.StateChangeListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottom_navigation.itemIconTintList = null

        val navController = findNavController(R.id.nav_host_fragment)
        bottom_navigation.setupWithNavController(navController)

    }

}
