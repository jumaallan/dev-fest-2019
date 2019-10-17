package com.androidstudy.movies.ui.views.repository

import com.androidstudy.movies.ui.views.api.ApiClient
import com.androidstudy.movies.ui.views.api.ApiService
import com.androidstudy.movies.ui.views.datastates.NetworkResult
import com.androidstudy.movies.ui.views.models.CharactersResponseModel
import java.io.IOException

interface CharactersRepo {
    suspend fun getCharacters(): NetworkResult<CharactersResponseModel>
}

class CharacterRepoImpl(private val apiService: ApiService) : CharactersRepo {
    override suspend fun getCharacters(): NetworkResult<CharactersResponseModel> {
        val response = apiService.getCharacters()
        return when {
            response.isSuccessful -> NetworkResult.Success(response.body()!!)
            else -> NetworkResult.Error(IOException("Could not get characters"))
        }
    }

}