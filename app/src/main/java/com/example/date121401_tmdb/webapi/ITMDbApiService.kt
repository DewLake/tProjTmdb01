package com.example.date121401_tmdb.webapi

import com.example.date121401_tmdb.webapi.model.MovieDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * REST API Aaccess point
 */
interface ITMDbApiService {

    @GET("movie/{movieId}")
    fun fetchMovieDetail(@Path("movieId") movieId: String): Call<MovieDetailResponse>

//    @GET("movie/{list}")
//    fun fetchMovieList(
//        @Path("list") list: String,
//        @Query("page") page: Int? = null
//    ): Call<TMDbApiResponse<MovieListResponse>>
} // end interface ITMDbApiService.