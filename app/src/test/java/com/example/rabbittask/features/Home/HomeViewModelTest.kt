package com.example.rabbittask.features.Home

import com.example.rabbittask.features.Home.fake_repo.FakeHomeRepo
import com.homyapplication.Base.BaseTest
import com.homyapplication.Utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class HomeViewModelTest : BaseTest() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fakeHomeRepository: FakeHomeRepo
    override fun provideInitialSetup() {
        fakeHomeRepository = FakeHomeRepo()
        homeViewModel = HomeViewModel(fakeHomeRepository)
    }


    @ExperimentalCoroutinesApi
    @Test
    fun getHomePageContent_ListOfAttractionsReturnd_returnSuccess() {
        homeViewModel.getHomePageContent()
        val value = homeViewModel.homePageResponse.getOrAwaitValue()
        MatcherAssert.assertThat(value.attractionList, CoreMatchers.not(CoreMatchers.nullValue()))
    }


    @ExperimentalCoroutinesApi
    @Test
    fun getHomePageContent_ListOfEventsReturnd_returnSuccess() {
        homeViewModel.getHomePageContent()
        val value = homeViewModel.homePageResponse.getOrAwaitValue()
        MatcherAssert.assertThat(value.eventsList, CoreMatchers.not(CoreMatchers.nullValue()))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getHomePageContent_ListOfHotSpotsReturnd_returnSuccess() {
        homeViewModel.getHomePageContent()
        val value = homeViewModel.homePageResponse.getOrAwaitValue()
        MatcherAssert.assertThat(value.hotSpotsList, CoreMatchers.not(CoreMatchers.nullValue()))
    }
}