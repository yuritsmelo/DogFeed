package br.ucsal.mobile.dogfeed.network

import com.squareup.moshi.Json

data class DogPhoto(
    @Json(name = "message") val imgSrcUrl: String,
    val status : String
)