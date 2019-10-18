package com.androidstudy.movies.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.androidstudy.movies.data.dao.CharactersDao
import com.androidstudy.movies.data.datastates.NetworkResult
import com.androidstudy.movies.data.network.ApiService
import com.androidstudy.movies.data.remote.Character
import com.androidstudy.movies.data.remote.CharactersResponseModel
import com.androidstudy.movies.utils.safeApiCall
import retrofit2.Retrofit
import java.io.IOException

class CharactersRepo(
    retrofit: Retrofit,
    charactersDao: CharactersDao
) {
    private var network = retrofit
    private var dao = charactersDao
    private val apiService = network.create(ApiService::class.java)

    suspend fun fetchCharacters() = safeApiCall(
        call = { getCharacters() },
        errorMessage = "Am error occurred"
    )

    private suspend fun getCharacters(): NetworkResult<CharactersResponseModel> {
        val response = apiService.getCharacters()
        return when {
            response.isSuccessful -> {
                val charactersResponseModel = response.body()
                charactersResponseModel?.results?.let { saveCharacters(it) }
                NetworkResult.Success(response.body()!!)
            }
            else -> NetworkResult.Error(IOException("Could not get characters"))
        }
    }

    fun fetchLocalCharacters(): LiveData<List<Character>> = liveData {
        emit(dao.getCharacters())
    }

    private suspend fun saveCharacters(charactersList: List<Character>) {
        dao.insertCharacters(charactersList)
    }

}