package com.example.samplekmmapp.android.viewmodel

import androidx.lifecycle.*
import com.example.samplekmmapp.Greeting
import com.example.samplekmmapp.repo.MainRepo

class MainViewModel(private val repo: MainRepo) : ViewModel() {

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress: LiveData<Boolean> = _showProgress

    val marsProperties = liveData {
        emit(repo.getMarsProperties())
    }

    val imageUrls = liveData {
        _showProgress.postValue(true)
        emit(repo.getImageUrls())
        _showProgress.postValue(false)
    }

    fun greet() = Greeting().greeting()
}