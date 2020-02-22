package com.example.splasho.di


import com.example.rabbittask.features.Home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Aslm on 1/1/2020
 */

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }

}