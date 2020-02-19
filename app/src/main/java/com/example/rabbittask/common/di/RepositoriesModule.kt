package com.floriaapp.vendor.common.di

import com.homyapplication.common.repositories.home_repo.HomeMainRepo
import com.homyapplication.common.repositories.home_repo.HomeMainUseCase
import org.koin.dsl.module

/**
 * Created by Aslm on 1/1/2020
 */

val repositoriesModule = module {
    single { HomeMainRepo(get()) as HomeMainUseCase }

}