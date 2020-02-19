package com.floriaapp.vendor.common.di

import com.floriaapp.vendor.common.network.createNetworkClient
import com.homyapplication.common.rest.*
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Aslm on 1/1/2020
 */


val retrofit: Retrofit = createNetworkClient()
private val HOME_API: HomeApi = retrofit.create(HomeApi::class.java)

val networkModule = module {
    single { HOME_API }

}