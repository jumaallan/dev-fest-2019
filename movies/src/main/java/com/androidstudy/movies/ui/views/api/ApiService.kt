package com.androidstudy.movies.ui.views.api

import com.androidstudy.movies.ui.views.models.CharactersResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api/character/")
    suspend fun getCharacters(): Response<CharactersResponseModel>

}