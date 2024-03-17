package com.alperen.moviekmmatil.util

import com.alperen.moviekmmatil.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}