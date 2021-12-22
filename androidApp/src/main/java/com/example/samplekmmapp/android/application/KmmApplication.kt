package com.example.samplekmmapp.android.application

import android.app.Application
import com.example.samplekmmapp.android.BuildConfig
import com.example.samplekmmapp.android.di.appModule
import com.example.samplekmmapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class KmmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initAndroidKoin()
    }

    private fun initAndroidKoin() {
        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@KmmApplication)
            modules(appModule)
        }
    }
}