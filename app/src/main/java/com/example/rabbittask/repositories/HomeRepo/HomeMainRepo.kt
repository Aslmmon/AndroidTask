package com.homyapplication.common.repositories.home_repo

import com.example.rabbittask.model.HomePageContent
import com.example.rabbittask.model.HomePageContentResponse
import com.homyapplication.common.rest.HomeApi

class HomeMainRepo (var mainApi:HomeApi ) : HomeMainUseCase {

    override suspend fun getHomePageContent(): HomePageContent {
        var result = mainApi.getHomePageContent()
        val homePageContent = HomePageContent(result.data.hot_spots,
            result.data.events,
            result.data.attractions)
        return homePageContent
    }

}