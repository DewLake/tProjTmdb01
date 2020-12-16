package com.example.date121401_tmdb.webapi.model.getnowplaying

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dates(
    @field:Json(name = "") val maximum: String,
    @field:Json(name = "") val minimum: String
)