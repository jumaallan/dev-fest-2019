package com.androidstudy.weather.ui.views.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidstudy.weather.ui.views.datastates.NetworkResult
import com.androidstudy.weather.ui.views.models.WeatherResponseModel
import com.androidstudy.weather.ui.views.repository.WeatherRepo
import com.androidstudy.weather.ui.views.utils.NonNullMediatorLiveData
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val weatherRepo = WeatherRepo()
    private val weatherMediatorLiveData = NonNullMediatorLiveData<WeatherResponseModel>()
    private val weatherError = NonNullMediatorLiveData<String>()

    fun getWeatherResponse(): LiveData<WeatherResponseModel> = weatherMediatorLiveData

    fun getWeatherError(): LiveData<String> = weatherError

    fun fetchWeather(cityName: String, units: String, appId: String) {
        viewModelScope.launch {
            when (val value = weatherRepo.fetchWeather(cityName, units, appId)) {
                is NetworkResult.Success -> weatherMediatorLiveData.postValue(value.data)
                is NetworkResult.Error -> weatherError.postValue(value.exception.message)
            }
        }
    }
}