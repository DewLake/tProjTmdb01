package com.example.date121401_tmdb.webapi

import android.os.Parcel
import android.os.Parcelable
import com.example.date121401_tmdb.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TmdbRequestInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // attach apk_key to query string. 幫 API Request 都加上 api_key
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()

        return chain.proceed(request)
    } // end intercept().
} // end class RequestInterceptor.