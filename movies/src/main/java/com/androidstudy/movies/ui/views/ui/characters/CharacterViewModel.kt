package com.androidstudy.movies.ui.views.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidstudy.movies.ui.views.datastates.NetworkResult
import com.androidstudy.movies.ui.views.models.CharactersResponseModel
import com.androidstudy.movies.ui.views.repository.CharactersRepo
import com.androidstudy.movies.ui.views.utils.NonNullMediatorLiveData
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val characterMediatorLiveData = NonNullMediatorLiveData<CharactersResponseModel>()
    private val characterError = NonNullMediatorLiveData<String>()
    private val charactersRepo = CharactersRepo()


    fun getCharactersResponse(): LiveData<CharactersResponseModel> = characterMediatorLiveData

    fun getCharactersError(): LiveData<String> = characterError

    fun getCharacters() {
        viewModelScope.launch {
            when (val value = charactersRepo.getCharacters()) {
                is NetworkResult.Success -> characterMediatorLiveData.postValue(value.data)
                is NetworkResult.Error -> characterError.postValue(value.exception.message)
            }
        }
    }
}