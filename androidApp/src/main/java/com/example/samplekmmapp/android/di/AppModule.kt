package com.example.samplekmmapp.android.di

import com.example.samplekmmapp.android.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel(get()) }
}