package com.example.date121401_tmdb.webapi

import android.util.Log
import com.example.date121401_tmdb.webapi.model.moviedetail.MovieDetailResponse
import com.example.date121401_tmdb.webapi.model.nowplaying.GetNowPlayingResponse
import com.example.date121401_tmdb.webapi.model.popular.GetPopularResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 實際與 API 接口 互動, 對應 API Service.
 * 送出請求(Request)/接收回覆(Response)
 */
object TmdbRepository {
    // TAG
    val TAG="[TAG]-${TmdbRepository::class.simpleName}"

    /**
     * 取得 TMDb 圖片網址
     * rfs: https://developers.themoviedb.org/3/getting-started/images
     */
    fun GetImageUrl(file_path: String, file_size:String = "w200"): String {
        Log.d("GetImageUrl"," $file_path")
        val basUrl = "https://image.tmdb.org/t/p/"
        // val url = "https://image.tmdb.org/t/p/w300/eShw0LB5CkoEfYtpUcXPD85oz5Q.jpg"
        val url = "$basUrl$file_size/$file_path"
        return url
    }

    /**
     * Get Now Playing
     */
    fun GetNowPlaying(
            page:Int = 1,
            onDataReadyCallback:(responseBody: GetNowPlayingResponse)->Unit
    ) {
        val apiService = TmdbRetrofitManager.apiService
        apiService.getNowPlaying(page).enqueue(object: Callback<GetNowPlayingResponse> {

            override fun onResponse(
                    call: Call<GetNowPlayingResponse>,
                    response: Response<GetNowPlayingResponse>
            ) {
                Log.d("$TAG-GetNowPlaying","onResponse")
                if(response.body() != null) {
                    onDataReadyCallback(response.body() as GetNowPlayingResponse)
                }
            }

            override fun onFailure(call: Call<GetNowPlayingResponse>, t: Throwable) {
                Log.d("$TAG-GetNowPlaying","onFailure")
            }

        })
    } // end GetNowPlaying().


    /**
     * Get Popular
     */
    fun GetPopular(
            page:Int = 1,
            onDataReadyCallback:(responseBody: GetPopularResponse)->Unit
    ) {
        val api = TmdbRetrofitManager.apiService
        api.getPopular(page).enqueue(object : Callback<GetPopularResponse>{
            override fun onResponse(call: Call<GetPopularResponse>, response: Response<GetPopularResponse>) {
                Log.d("$TAG-GetPopular","onResponse")
                if(response.body() != null) {
                    onDataReadyCallback(response.body() as GetPopularResponse)
                }
            }

            override fun onFailure(call: Call<GetPopularResponse>, t: Throwable) {
                Log.d("$TAG-GetPopular","onFailure")
            }

        })
    } // end GetPopular().

    /**
     * Get Movie Detail
     */
    fun GetMovieDetail(
            movieId:String,
            onDataReadyCallback: (MovieDetailResponse)->Unit
    ) {
        val api = TmdbRetrofitManager.apiService
        api.getMovieDetail(movieId).enqueue(object: Callback<MovieDetailResponse>{

            override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                Log.d("$TAG-GetMovieDetail","onResponse")
                if(response.body() != null) {
                    onDataReadyCallback(response.body() as MovieDetailResponse)
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.d("$TAG-GetMovieDetail","onFailure")
            }

        }) // end api.getMovieDetail().enqueue().
    } // end GetMovieDetail().
} // end class TmdbRepository.