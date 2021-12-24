package com.example.samplekmmapp.android.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.samplekmmapp.Greeting
import com.example.samplekmmapp.repo.MainRepo
import kotlinx.coroutines.flow.*

class MainViewModel(private val repo: MainRepo) : ViewModel() {

    private var counter = 0

    val marsProperties = flow {
        emit(repo.getMarsProperties())
    }.stateInDefault("")

//    val imageUrls = flow {
//        while (true) {
//            val urls = repo.getImageUrls()
//            Log.d(TAG, "imageUrls: ${urls[0]}")
//            emit(Result.Success(urls))
//            delay(2000L)
//        }
//    }.stateInDefault(Result.Loading)

    val imageUrls = flow<Result<List<String>>> {
        val map = repo.getImageUrlsFlow().map {
            Log.d(TAG, "imageUrls:${++counter}: ${it[0]}")
            Result.Success(it)
        }
        emitAll(map)
    }.onStart {
        emit(Result.Loading)
    }.asLiveData()



    private fun <T> Flow<T>.stateInDefault(initialValue: T): StateFlow<T> =
        stateIn(initialValue = initialValue,
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(3000L, 0L))

    fun greet() = Greeting().greeting()

    companion object {
        private const val TAG = "MainViewModel"
    }
}