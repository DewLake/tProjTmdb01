package com.example.date121401_tmdb.webapi.model

data class GetNowPlayingResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)