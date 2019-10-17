package com.androidstudy.movies.ui.views.repository

import com.androidstudy.movies.ui.views.api.ApiClient
import com.androidstudy.movies.ui.views.api.ApiService
import com.androidstudy.movies.ui.views.datastates.NetworkResult
import com.androidstudy.movies.ui.views.models.CharactersResponseModel
import java.io.IOException

class CharactersRepo {
    private val apiService = ApiClient().getClient().create(ApiService::class.java)

    suspend fun getCharacters(): NetworkResult<CharactersResponseModel> {
        val response = apiService.getCharacters()
        return when {
            response.isSuccessful -> NetworkResult.Success(response.body()!!)
            else -> NetworkResult.Error(IOException("Could not get characters"))
        }
    }
}