package com.homyapplication.common.repositories.home_repo

import com.example.rabbittask.model.HomePageContentResponse


interface HomeMainUseCase {
    suspend fun getHomePageContent() : HomePageContentResponse
}