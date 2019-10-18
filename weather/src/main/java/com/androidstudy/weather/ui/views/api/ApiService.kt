package com.androidstudy.weather.ui.views.api

import com.androidstudy.weather.ui.views.models.WeatherResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") appid: String
    ) : Response<WeatherResponseModel>
}