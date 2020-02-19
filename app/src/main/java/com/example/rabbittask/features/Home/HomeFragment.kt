package com.example.rabbittask.features.Home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.rabbittask.R
import com.example.rabbittask.features.MainActivityViewModel
import com.example.rabbittask.features.adapter.AttractionsAdapter
import com.example.rabbittask.features.adapter.EventsAdapter
import com.example.rabbittask.features.adapter.HotSpotAdapter
import com.example.rabbittask.model.Attraction
import com.example.rabbittask.model.Event
import com.example.rabbittask.model.HotSpot
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(R.layout.fragment_home),HotSpotAdapter.Interaction,
    EventsAdapter.Interaction ,AttractionsAdapter.Interaction{

    private val mainViewModel: MainActivityViewModel by viewModel()
    lateinit var hotSpotAdapter: HotSpotAdapter
    lateinit var eventsAdapter: EventsAdapter
    lateinit var attractionAdapter: AttractionsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()



        mainViewModel.getHomePageContent()
        mainViewModel.homePageResponse.observe(viewLifecycleOwner, Observer {
            Log.i(javaClass.simpleName, it.toString())
            Log.i(javaClass.simpleName, it.data.hot_spots.size.toString())

            hotSpotAdapter.submitList(it.data.hot_spots)
            eventsAdapter.submitList(it.data.events)
            attractionAdapter.submitList(it.data.attractions)
        })
        mainViewModel.ErrorMessage.observe(viewLifecycleOwner, Observer {
            Log.i(javaClass.simpleName, it.toString())

        })
    }


    private fun initRecycler() {
        recycler.let {
            it.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            hotSpotAdapter =
                HotSpotAdapter(
                    this
                )
            it.adapter = hotSpotAdapter
        }
        recycler_events.let {
            it.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            eventsAdapter =
                EventsAdapter(
                    this
                )
            it.adapter = eventsAdapter
        }

        recycler_attractions.let {
            it.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            attractionAdapter=
                AttractionsAdapter(
                    this
                )
            it.adapter = attractionAdapter
        }
    }

    override fun onItemSelected(position: Int, item: HotSpot) {

    }

    override fun onItemSelected(position: Int, item: Event) {

    }

    override fun onItemSelected(position: Int, item: Attraction) {

    }
}
