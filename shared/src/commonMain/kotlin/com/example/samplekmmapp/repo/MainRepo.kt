package com.example.samplekmmapp.repo

interface MainRepo {
    suspend fun getMarsProperties(): String
    suspend fun getImageUrls(): List<String>
}