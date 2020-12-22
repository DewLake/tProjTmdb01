package com.example.date121401_tmdb.webapi.model.moviedetail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionCountry(
    @field: Json(name = "iso_3166_1") val iso_3166_1: String,
    @field: Json(name = "name") val name: String
)