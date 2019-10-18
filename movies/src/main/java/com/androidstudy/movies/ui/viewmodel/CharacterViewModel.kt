package com.androidstudy.movies.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidstudy.movies.data.datastates.NetworkResult
import com.androidstudy.movies.data.models.CharactersResponseModel
import com.androidstudy.movies.data.repository.CharactersRepo
import com.androidstudy.movies.utils.NonNullMediatorLiveData
import kotlinx.coroutines.launch

class CharacterViewModel(
    charactersRepo: CharactersRepo
) : ViewModel() {

    private val characterMediatorLiveData =
        NonNullMediatorLiveData<CharactersResponseModel>()
    private val characterError = NonNullMediatorLiveData<String>()
    private val repo = charactersRepo

    fun getCharactersResponse(): LiveData<CharactersResponseModel> = characterMediatorLiveData

    fun getCharactersError(): LiveData<String> = characterError

    fun getCharacters() {
        viewModelScope.launch {
            when (val value = repo.getCharacters()) {
                is NetworkResult.Success -> characterMediatorLiveData.postValue(value.data)
                is NetworkResult.Error -> characterError.postValue(value.exception.message)
            }
        }
    }
}