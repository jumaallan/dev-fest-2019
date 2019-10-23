package com.androidstudy.movies.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidstudy.devfest19.core.api.NetworkResult
import com.androidstudy.devfest19.core.livedata.NonNullMediatorLiveData
import com.androidstudy.movies.data.remote.Character
import com.androidstudy.movies.data.remote.CharactersResponseModel
import com.androidstudy.movies.data.repository.CharactersRepo
import kotlinx.coroutines.launch

class CharacterViewModel(
    charactersRepo: CharactersRepo
) : ViewModel() {

    private val repo = charactersRepo
    private val charactersMediatorLiveData = NonNullMediatorLiveData<CharactersResponseModel>()
    private val charactersError = NonNullMediatorLiveData<String>()

    fun fetchLocalCharacters(): LiveData<List<Character>> {
        return repo.fetchLocalCharacters()
    }

    fun getCharactersResponse(): LiveData<CharactersResponseModel> = charactersMediatorLiveData

    fun getCharactersError(): LiveData<String> = charactersError

    fun getCharacters() {
        viewModelScope.launch {
            when (val value = repo.fetchCharacters()) {
                is NetworkResult.Success -> charactersMediatorLiveData.postValue(value.data)
                is NetworkResult.Error -> charactersError.postValue(value.exception.message)
            }
        }
    }

}