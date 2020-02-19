package com.example.rabbittask.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rabbittask.R
import com.example.rabbittask.model.Event
import com.example.rabbittask.model.HotSpot
import com.example.rabbittask.repositories.HomeRepo.adapter.EventsAdapter
import com.example.rabbittask.repositories.HomeRepo.adapter.HotSpotAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) ,
    HotSpotAdapter.Interaction,EventsAdapter.Interaction {
    private val mainViewModel: MainActivityViewModel by viewModel()
    lateinit var hotSpotAdapter: HotSpotAdapter
    lateinit var eventsAdapter: EventsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()

        mainViewModel.getHomePageContent()
        mainViewModel.homePageResponse.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())
            Log.i(javaClass.simpleName, it.data.hot_spots.size.toString())

            hotSpotAdapter.submitList(it.data.hot_spots)
            eventsAdapter.submitList(it.data.events)
        })
        mainViewModel.ErrorMessage.observe(this, Observer {
            Log.i(javaClass.simpleName, it.toString())

        })

    }

    private fun initRecycler() {
        recycler.let {
            it.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            hotSpotAdapter =
                HotSpotAdapter(
                    this
                )
            it.adapter = hotSpotAdapter
        }
        recycler_events.let {
            it.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            eventsAdapter =
                EventsAdapter(
                    this
                )
            it.adapter = eventsAdapter
        }
    }

    override fun onItemSelected(position: Int, item: HotSpot) {

    }

    override fun onItemSelected(position: Int, item: Event) {

    }
}
