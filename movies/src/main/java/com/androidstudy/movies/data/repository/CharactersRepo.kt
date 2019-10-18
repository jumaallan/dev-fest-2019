package com.androidstudy.movies.data.repository

import com.androidstudy.movies.data.dao.MovieDao
import com.androidstudy.movies.data.datastates.NetworkResult
import com.androidstudy.movies.data.network.ApiService
import com.androidstudy.movies.data.remote.CharactersResponseModel
import retrofit2.Retrofit
import java.io.IOException

class CharactersRepo(
    retrofit: Retrofit,
    movieDao: MovieDao
) {
    private var network = retrofit
    private var dao = movieDao
    private val apiService = network.create(ApiService::class.java)

    suspend fun getCharacters(): NetworkResult<CharactersResponseModel> {
        val response = apiService.getCharacters()
        return when {
            response.isSuccessful -> NetworkResult.Success(response.body()!!)
            else -> NetworkResult.Error(IOException("Could not get characters"))
        }
    }
}