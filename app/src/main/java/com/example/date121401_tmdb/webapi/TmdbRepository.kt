package com.example.date121401_tmdb.webapi

import android.util.Log
import com.example.date121401_tmdb.webapi.model.nowplaying.GetNowPlayingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 實際與 API 接口 互動, 對應 API Service.
 * 送出請求(Request)/接收回覆(Response)
 */
class TmdbRepository {
    // TAG
    val TAG="[TAG]-${TmdbRepository::class.simpleName}"

    /**
     * Get Now Playing
     */
    private fun GetNowPlaying(
            page:Int = 1,
            onResponseCallback:(response: GetNowPlayingResponse)->Unit,
            onFailureCallback:(t: Throwable)->Unit
    ) {
        val apiService = TmdbRetrofitManager.service
        apiService.getNowPlaying(page).enqueue(object: Callback<GetNowPlayingResponse> {
            override fun onResponse(
                    call: Call<GetNowPlayingResponse>,
                    response: Response<GetNowPlayingResponse>
            ) {
                Log.d("$TAG-GetNowPlaying","onResponse")
                if(response.body() != null) {
                    onResponseCallback(response.body() as GetNowPlayingResponse)
                }
            }

            override fun onFailure(call: Call<GetNowPlayingResponse>, t: Throwable) {
                Log.d("$TAG-GetNowPlaying","onFailure")
                onFailureCallback(t)
            }

        })
    } // end GetNowPlaying().
} // end class TmdbRepository.