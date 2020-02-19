package com.homyapplication.common.repositories.home_repo

import com.homyapplication.common.rest.HomeApi

class HomeMainRepo (var mainApi:HomeApi ) : HomeMainUseCase {

    override suspend fun getHomePageContent() = mainApi.getHomePageContent()

}