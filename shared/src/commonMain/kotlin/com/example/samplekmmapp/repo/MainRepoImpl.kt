package com.example.samplekmmapp.repo

import com.example.samplekmmapp.network.NetworkApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainRepoImpl(private val networkApi: NetworkApi) : MainRepo {

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
}