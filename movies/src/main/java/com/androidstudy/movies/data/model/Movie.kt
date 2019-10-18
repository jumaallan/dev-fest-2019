package com.androidstudy.movies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val name: String,
    val url: String
)