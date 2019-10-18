package com.androidstudy.movies.data.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.androidstudy.movies.data.model.Movie

@Dao
interface MovieDao : BaseDao<Movie> {

    @Query("SELECT * FROM Movie")
    fun fetchMovies(): DataSource.Factory<Int, Movie>

}