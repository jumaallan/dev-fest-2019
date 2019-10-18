package com.androidstudy.movies.data.network

import com.androidstudy.movies.data.models.CharactersResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api/character/")
    suspend fun getCharacters(): Response<CharactersResponseModel>

}