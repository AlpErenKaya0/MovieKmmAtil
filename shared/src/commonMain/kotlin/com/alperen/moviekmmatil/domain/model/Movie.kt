package com.alperen.moviekmmatil.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val releaseDate: String
)