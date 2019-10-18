package com.androidstudy.movies.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)