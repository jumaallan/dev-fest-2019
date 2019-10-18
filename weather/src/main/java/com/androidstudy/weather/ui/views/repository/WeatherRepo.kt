package com.androidstudy.weather.ui.views.repository

import com.androidstudy.weather.ui.views.api.ApiClient
import com.androidstudy.weather.ui.views.api.ApiService
import com.androidstudy.weather.ui.views.datastates.NetworkResult
import com.androidstudy.weather.ui.views.models.WeatherResponseModel
import com.androidstudy.weather.ui.views.utils.safeApiCall
import java.io.IOException

class WeatherRepo {
    private val apiService = ApiClient().getClient().create(ApiService::class.java)

    suspend fun fetchWeather(cityName: String, units: String, appId: String) = safeApiCall(
        call = { getWeather(cityName, units, appId) },
        errorMessage = "An error occurred"
    )

    private suspend fun getWeather(
        cityName: String,
        units: String,
        appId: String
    ): NetworkResult<WeatherResponseModel> {
        val response = apiService.getWeather(cityName, units, appId)
        return when {
            response.isSuccessful -> NetworkResult.Success(response.body()!!)
            else -> NetworkResult.Error(IOException("Could not get weather data"))
        }
    }
}