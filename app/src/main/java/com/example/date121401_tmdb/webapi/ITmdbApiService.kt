package com.example.date121401_tmdb.webapi

import com.example.date121401_tmdb.webapi.model.MovieDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * REST API Access point.
 * Retrofit turns your HTTP API into a Java interface.
 * Retrofit 讓各 API 連線方法(Access/End point) 轉換成 介面方法(interface).
 * 各連線接口統一管理, 連線方式(GET, POST)、路徑、參數
 */
interface ITmdbApiService {

    @GET("movie/{movieId}")     // {} 為路徑參數, @Path 會將參數帶入至該位置
    fun fetchMovieDetail(@Path("movieId") movieId: String): Call<MovieDetailResponse>

    @GET("movie/now_playing")
    fun getNowPlaying(@Query("page") page:Int): Call<>


//    @GET("movie/{list}")
//    fun fetchMovieList(
//        @Path("list") list: String,
//        @Query("page") page: Int? = null
//    ): Call<TMDbApiResponse<MovieListResponse>>
} // end interface ITMDbApiService.