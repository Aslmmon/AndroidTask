package com.example.rabbittask.features.Home.fake_repo

import com.example.rabbittask.model.Attraction
import com.example.rabbittask.model.Event
import com.example.rabbittask.model.HomePageContent
import com.example.rabbittask.model.HotSpot
import com.homyapplication.common.repositories.home_repo.HomeMainUseCase

class FakeHomeRepo : HomeMainUseCase {
    var first = listOf<HotSpot>()
    var second = listOf<Event>()
    var third = listOf<Attraction>()
    var homePageContent = HomePageContent(first,second,third)

    override suspend fun getHomePageContent(): HomePageContent  = homePageContent
}