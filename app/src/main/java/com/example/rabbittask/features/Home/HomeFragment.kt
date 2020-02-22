package com.example.rabbittask.features.Home


import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rabbittask.R
import com.example.rabbittask.features.Home.adapter.AttractionsAdapter
import com.example.rabbittask.features.Home.adapter.EventsAdapter
import com.example.rabbittask.features.Home.adapter.HotSpotAdapter
import com.example.rabbittask.model.*
import com.homyapplication.common.Connection
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.loading.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(R.layout.fragment_home),
    HotSpotAdapter.Interaction,
    EventsAdapter.Interaction,
    AttractionsAdapter.Interaction {

    private val mainViewModel: HomeViewModel by viewModel()
    lateinit var hotSpotAdapter: HotSpotAdapter
    lateinit var eventsAdapter: EventsAdapter
    lateinit var attractionAdapter: AttractionsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        loading.start()

        if (Connection.isNetworkAvailable(requireActivity())) mainViewModel.getHomePageContent()

        mainViewModel.homePageResponse.observe(viewLifecycleOwner, Observer {

            hotSpotAdapter.submitList(it.hotSpotsList as ArrayList<HotSpot>)
            eventsAdapter.submitList(it.eventsList)
            attractionAdapter.submitList(it.attractionList)
            loading.stop()
        })
        mainViewModel.ErrorMessage.observe(viewLifecycleOwner, Observer {
            Log.i(javaClass.simpleName, it.toString())
            loading.stop()


        })
    }


    private fun initRecycler() {
        recycler.let {
            it.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            hotSpotAdapter =
                HotSpotAdapter(
                    this
                )
            it.adapter = hotSpotAdapter
            it.layoutAnimation =
                AnimationUtils.loadLayoutAnimation(requireActivity(), R.anim.layout_from_right)

        }
        recycler_events.let {
            it.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            eventsAdapter =
                EventsAdapter(
                    this
                )
            it.adapter = eventsAdapter
            it.layoutAnimation = AnimationUtils.loadLayoutAnimation(
                requireActivity(),
                R.anim.layout_fall_down_animation
            )

        }

        recycler_attractions.let {
            it.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            attractionAdapter =
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
