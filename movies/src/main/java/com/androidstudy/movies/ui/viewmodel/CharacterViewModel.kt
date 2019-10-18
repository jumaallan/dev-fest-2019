package com.androidstudy.movies.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.androidstudy.movies.data.model.Movie
import com.androidstudy.movies.data.repository.CharactersRepo

class CharacterViewModel(
    charactersRepo: CharactersRepo
) : ViewModel() {

    private val repo = charactersRepo

    fun fetchMovies(): LiveData<PagedList<Movie>> {
        return repo.fetchMovies()
    }

}