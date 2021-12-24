package com.example.samplekmmapp.repo

import kotlinx.coroutines.flow.Flow

interface MainRepo {
    suspend fun getMarsProperties(): String
    suspend fun getImageUrls(): List<String>
    fun getImageUrlsFlow(): Flow<List<String>>
}