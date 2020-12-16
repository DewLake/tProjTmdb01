package com.example.date121401_tmdb.webapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object TmdbRetrofitManager {
    // base url
    private const val baseUrl = "https://api.themoviedb.org/3/"

    // okHttpClient:
    // Retrofit 底層也是用 OkHttp, 在此可設定自己的 okHttpClient
    val okHttpClient: OkHttpClient
        get() {
            val httpLoggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

            val builder = OkHttpClient.Builder().apply {
                addInterceptor(httpLoggingInterceptor)
                addInterceptor(TmdbRequestInterceptor())
            }
            return builder.build()
        }

    // retrofit
//    val retrofit: Retrofit = Retrofit.Builder().baseUrl(baseUrl).build()
    val retrofit: Retrofit
        get() {
            val builder = Retrofit.Builder().apply {
                baseUrl(baseUrl)
                addConverterFactory(MoshiConverterFactory.create())
                client(okHttpClient)
            }
            return builder.build()
        }

    // api service
    val service: ITmdbApiService = retrofit.create(ITmdbApiService::class.java)
} // end object RetrofitManager.
