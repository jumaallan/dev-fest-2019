package com.androidstudy.movies.data.converters

import androidx.room.TypeConverter
import com.androidstudy.movies.data.remote.Location
import com.androidstudy.movies.data.remote.Origin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromString(location: String): Location {
        val objectType = object : TypeToken<Location>() {

        }.type
        return Gson().fromJson<Location>(location, objectType)

    }

    @TypeConverter
    fun fromObject(location: Location): String {
        return Gson().toJson(location)
    }

    @TypeConverter
    fun oiginFromString(origin: String): Origin {
        val objectType = object : TypeToken<Origin>() {

        }.type
        return Gson().fromJson<Origin>(origin, objectType)

    }

    @TypeConverter
    fun originFromObject(origin: Origin): String {
        return Gson().toJson(origin)
    }

    @TypeConverter
    fun listFromString(origin: String): List<String> {
        val objectType = object : TypeToken<List<String>>() {

        }.type
        return Gson().fromJson<List<String>>(origin, objectType)

    }

    @TypeConverter
    fun listFromObject(origin: List<String>): String {
        return Gson().toJson(origin)
    }
}