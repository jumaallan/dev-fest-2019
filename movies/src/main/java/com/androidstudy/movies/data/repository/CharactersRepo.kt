package com.androidstudy.movies.data.repository

import com.androidstudy.movies.data.datastates.NetworkResult
import com.androidstudy.movies.data.models.CharactersResponseModel
import com.androidstudy.movies.data.network.ApiService
import com.androidstudy.movies.ui.views.api.ApiClient
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