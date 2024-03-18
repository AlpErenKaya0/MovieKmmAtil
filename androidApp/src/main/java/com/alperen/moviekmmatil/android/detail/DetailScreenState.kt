package com.alperen.moviekmmatil.android.detail

import com.alperen.moviekmmatil.domain.model.Movie

data class DetailScreenState(
    var loading : Boolean = false,
    var movie: Movie?= null,
    var errorMessage: String?=null
)
