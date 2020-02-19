package com.example.rabbittask.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rabbittask.model.HomePageContentResponse
import com.homyapplication.common.bases.launchDataLoad
import com.homyapplication.common.repositories.home_repo.HomeMainUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip

class MainActivityViewModel(val homeMainUseCase: HomeMainUseCase) : ViewModel() {

    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage

    private val _homePageResponse = MutableLiveData<HomePageContentResponse>()
    val homePageResponse: LiveData<HomePageContentResponse>
        get() = _homePageResponse



    fun getHomePageContent() {
        launchDataLoad(execution = {
            _homePageResponse.value = homeMainUseCase.getHomePageContent()
        },errorReturned = {e ->
            val error = e.message
            _ErrorMessage.value = error
        })
    }




}