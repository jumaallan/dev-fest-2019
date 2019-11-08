package com.androidstudy.movies.data.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var chainRequest = chain.request()
        chainRequest = if (chainRequest.headers.names().contains("No-Auth")) {
            chainRequest.newBuilder().removeHeader("No-Auth").build()
        } else {
            chainRequest.newBuilder()
                .addHeader("Authorization", "Bearer " + "your_token")
                .build()
        }
        return chain.proceed(chainRequest)
    }
}