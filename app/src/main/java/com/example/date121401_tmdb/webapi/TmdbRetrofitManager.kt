package com.example.date121401_tmdb.webapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object TmdbRetrofitManager {
    // base url
    private const val baseUrl = "https://api.github.com/"

    // okHttpClient:
    // Retrofit 底層也是用 OkHttp, 在此可設定自己的 okHttpClient
    val okHttpClient: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder().apply {
                addInterceptor(TmdbRequestInterceptor())
            }
            return builder.build()
        }

    // retrofit
    val retrofit: Retrofit = Retrofit.Builder().baseUrl(baseUrl).build()

    // api service
    val SERVICE: ITmdbApiService = retrofit.create(ITmdbApiService::class.java)
} // end object RetrofitManager.
