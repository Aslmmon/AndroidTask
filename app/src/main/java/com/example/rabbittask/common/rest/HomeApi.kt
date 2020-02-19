package com.homyapplication.common.rest

import com.example.rabbittask.model.HomePageContentResponse
import retrofit2.http.GET


interface HomeApi {

    @GET("/api/home")
    suspend fun getHomePageContent() : HomePageContentResponse
}