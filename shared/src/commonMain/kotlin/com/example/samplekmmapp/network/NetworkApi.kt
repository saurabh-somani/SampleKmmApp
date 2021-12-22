package com.example.samplekmmapp.network

import com.example.samplekmmapp.model.MarsProperty
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class NetworkApi(private val client: HttpClient) {

    suspend fun getMarsProperties(): List<MarsProperty> = client.get {
        url("https://mars.udacity.com/realestate")
    }
}