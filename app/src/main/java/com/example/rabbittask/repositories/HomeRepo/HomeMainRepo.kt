package com.homyapplication.common.repositories.home_repo

import com.homyapplication.common.rest.HomeApi

class HomeMainRepo (var mainApi:HomeApi ) : HomeMainUseCase {

    override suspend fun getHomePageContent() = mainApi.getHomePageContent()

    //override suspend fun getSliderImages() = mainApi.getSliderImages()

    //override suspend fun pushTokenToServer(token:String, deviceId:String)  = mainApi.sendTokenToServer(token, deviceId)
}