package com.androidstudy.movies.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.RoomWarnings
import com.androidstudy.movies.data.remote.Character

@Dao
interface CharactersDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertCharacters(characterList: List<Character>)

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * FROM character")
    suspend fun getCharacters(): List<Character>
}