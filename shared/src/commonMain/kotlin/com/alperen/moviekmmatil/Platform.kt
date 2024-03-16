package com.alperen.moviekmmatil

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform