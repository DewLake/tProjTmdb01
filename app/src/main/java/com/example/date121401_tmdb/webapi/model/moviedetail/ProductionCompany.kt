package com.example.date121401_tmdb.webapi.model.moviedetail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ProductionCompany(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "logo_path") val logo_path: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "origin_country") val origin_country: String
)