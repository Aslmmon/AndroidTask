package com.example.rabbittask.features

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rabbittask.R
import com.example.rabbittask.common.Utils
import com.example.rabbittask.common.bases.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton
import kotlinx.android.synthetic.main.bottom_navigation.*
import kotlinx.android.synthetic.main.loading.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    private var currentNavController: LiveData<NavController>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

        bottom_navigation.itemIconTintList = null

        val icon = ImageView(this)
        icon.setImageDrawable(resources.getDrawable(R.drawable.bellman_bottom_icon))
        val fab = FloatingActionButton.Builder(this)
            .setBackgroundDrawable(R.drawable.bellman_bottom_icon).setPosition(5).build()


        val icon1 = ImageView(this)
        icon1.setImageDrawable(resources.getDrawable(R.drawable.hotspot_icon))

        val icon2 = ImageView(this)
        icon2.setImageDrawable(resources.getDrawable(R.drawable.events_icon))
        val icon3 = ImageView(this)
        icon3.setImageDrawable(resources.getDrawable(R.drawable.attarctions_icon))

        val icon4 = ImageView(this)
        icon4.setImageDrawable(resources.getDrawable(R.drawable.small_grey_location_pin))


        val itemBuilder = SubActionButton.Builder(this)
        val btn = itemBuilder.setContentView(icon1).build()
        val btn2 = itemBuilder.setContentView(icon2).build()
        val btn3 = itemBuilder.setContentView(icon3).build()
        val btn4 = itemBuilder.setContentView(icon4).build()


        val actionMenu = FloatingActionMenu.Builder(this)
            .addSubActionView(btn)
            .addSubActionView(btn2)
            .addSubActionView(btn3)
            .addSubActionView(btn4)
            .enableAnimations()
            .attachTo(fab)
            .build()

        val navController = findNavController(R.id.nav_host_fragment)
        bottom_navigation.setupWithNavController(navController)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {

        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottom_navigation) //BottomNavigationView의 id val navGraphIds = listOf(R.navigation.notices, R.navigation.setting)//graph들의 id // Setup the bottom navigation view with a list of navigation graphs val controller = bottomNavigationView.setupWithNavController( navGraphIds = navGraphIds, fragmentManager = supportFragmentManager, containerId = R.id.nav_host_container, //FragmentContainerView의 id intent = intent )
        val navgraphs = listOf(R.navigation.nav_graph)
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navgraphs,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )

        currentNavController = controller


    }

}
