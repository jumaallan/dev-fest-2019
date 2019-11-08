package com.androidstudy.movies.data.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var chainRequest = chain.request()
        val url =
            chainRequest.url.newBuilder().addQueryParameter("Authorization", "your_key").build()
        chainRequest = chainRequest.newBuilder().url(url).build()
        return chain.proceed(chainRequest)
    }
}