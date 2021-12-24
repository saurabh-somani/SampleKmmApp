package com.example.samplekmmapp.android.viewmodel

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<T>(val value: T) : Result<T>()
    data class Failure(val error: Throwable) : Result<Nothing>()
}
