package com.example.date121401_tmdb.webapi

import android.os.Parcel
import android.os.Parcelable
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // attach query string with apk_key.
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", "apikey")
            .build()

        return chain.proceed(request)
    } // end intercept().
} // end class RequestInterceptor.