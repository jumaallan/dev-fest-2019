package com.androidstudy.movies.data

import androidx.room.RoomDatabase
import com.androidstudy.movies.data.dao.MovieDao
import com.androidstudy.movies.data.model.Movie

@androidx.room.Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}

