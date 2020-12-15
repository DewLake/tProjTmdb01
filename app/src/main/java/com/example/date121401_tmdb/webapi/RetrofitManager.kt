package com.example.date121401_tmdb.webapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitManager {
    // base url
    private const val baseUrl = "https://api.github.com/"
    // okHttpClient:
    // Retrofit 底層也是用 OkHttp, 在此可設定自己的 okHttpClient
    val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
    // retrofit
    val retrofit: Retrofit = Retrofit.Builder().baseUrl(baseUrl).build()
    //
    // api service
    val service: ITMDbApiService = retrofit.create(ITMDbApiService::class.java)
} // end object RetrofitManager.
