package com.homyapplication.common.repositories.home_repo

import com.example.rabbittask.model.HomePageContent


interface HomeMainUseCase {
    suspend fun getHomePageContent() : HomePageContent
}