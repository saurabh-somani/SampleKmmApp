package com.example.samplekmmapp.di

import com.example.samplekmmapp.network.NetworkApi
import com.example.samplekmmapp.repo.MainRepo
import com.example.samplekmmapp.repo.MainRepoImpl
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.*
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val commonModule = module {

    factory<MainRepo> { MainRepoImpl(get()) }
    factory { NetworkApi(get()) }
    single { httpClient }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}

private val httpClient = HttpClient {
    install(JsonFeature) {
        val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
        serializer = KotlinxSerializer(json)
        acceptContentTypes = acceptContentTypes + ContentType.Text.Any
    }
}