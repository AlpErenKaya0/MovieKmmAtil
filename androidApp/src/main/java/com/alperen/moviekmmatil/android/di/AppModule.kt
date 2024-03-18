package com.alperen.moviekmmatil.android.di

import com.alperen.moviekmmatil.android.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import com.alperen.moviekmmatil.android.home.HomeViewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel { parametersHolder ->  DetailViewModel(get(), movieId = parametersHolder.get()) }
}