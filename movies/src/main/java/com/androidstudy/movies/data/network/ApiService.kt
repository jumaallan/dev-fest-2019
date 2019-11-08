package com.androidstudy.movies.data.network

import com.androidstudy.movies.data.remote.CharactersResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("/api/character/")
    suspend fun getCharacters(): Response<CharactersResponseModel>

    @GET("/api/character/")
    @Headers("No-Auth : true")
    suspend fun getCharactersNoAuth(): Response<CharactersResponseModel>

}