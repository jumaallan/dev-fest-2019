package com.androidstudy.movies.data

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androidstudy.movies.data.converters.Converters
import com.androidstudy.movies.data.dao.CharactersDao
import com.androidstudy.movies.data.dao.MovieDao
import com.androidstudy.movies.data.model.Movie
import com.androidstudy.movies.data.remote.Character

@androidx.room.Database(
    entities = [Movie::class, Character::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)

abstract class Database : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun charactersDao(): CharactersDao
}


