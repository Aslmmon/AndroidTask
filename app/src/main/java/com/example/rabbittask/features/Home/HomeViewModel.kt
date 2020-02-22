package com.example.rabbittask.features.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rabbittask.model.HomePageContent
import com.homyapplication.common.bases.launchDataLoad
import com.homyapplication.common.repositories.home_repo.HomeMainUseCase

class HomeViewModel(val homeMainUseCase: HomeMainUseCase) : ViewModel() {


    /**
     * MutableLiveData to set value of Error to LiveData
     */
    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String>
        get() = _ErrorMessage

    /**
     * MutableLiveData to set value of Response to LiveData
     */
    private val _homePageResponse = MutableLiveData<HomePageContent>()
    val homePageResponse: LiveData<HomePageContent>
        get() = _homePageResponse



    /**
     * function to Get ListsOf HomePageContent
     */
    fun getHomePageContent() {
        /**
         * laundchDataLoad is Extension Function that run
         * function in ViewModel Scope
         */
        launchDataLoad(execution = {
            _homePageResponse.value = homeMainUseCase.getHomePageContent()
        },errorReturned = {e ->
            val error = e.message
            _ErrorMessage.value = error
        })
    }




}