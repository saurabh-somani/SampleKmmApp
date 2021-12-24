package com.example.samplekmmapp.repo

import com.example.samplekmmapp.network.NetworkApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainRepoImpl : MainRepo, KoinComponent {

    private val networkApi: NetworkApi by inject()

    override suspend fun getMarsProperties(): String {
        val marsProperties = networkApi.getMarsProperties()
        return Json.encodeToString(marsProperties)
    }

    override suspend fun getImageUrls(): List<String> {
        val marsProperties = networkApi.getMarsProperties()
        return marsProperties.map {
            it.imgSrcUrl
        }
    }

    override fun getImageUrlsFlow(): Flow<List<String>> = flow {
        while (true) {
            val urls = getImageUrls()
            emit(urls)
            delay(2000L)
        }
    }
}