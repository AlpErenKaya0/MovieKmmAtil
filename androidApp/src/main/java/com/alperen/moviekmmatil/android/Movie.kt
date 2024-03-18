package com.alperen.moviekmmatil.android

import android.app.Application
import com.alperen.moviekmmatil.android.di.appModule
import com.alperen.moviekmmatil.di.getSharedModules
import org.koin.core.context.startKoin

class Movie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules() )
        }
    }
}