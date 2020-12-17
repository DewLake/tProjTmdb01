package com.example.date121401_tmdb.webapi.model.nowplaying

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetNowPlayingResponse(
    @field:Json(name = "dates") val dates: Dates,
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "results") val results: List<Result>,
    @field:Json(name = "total_pages") val total_pages: Int,
    @field:Json(name = "total_results") val total_results: Int
)