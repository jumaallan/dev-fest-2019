package com.androidstudy.weather.ui.views.ui.views.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.androidstudy.weather.BuildConfig
import com.androidstudy.weather.R
import com.androidstudy.weather.ui.views.models.WeatherResponseModel
import com.androidstudy.weather.ui.views.ui.viewmodels.WeatherViewModel
import com.androidstudy.weather.ui.views.utils.nonNull
import com.androidstudy.weather.ui.views.utils.observe
import com.androidstudy.weather.ui.views.utils.toDate
import kotlinx.android.synthetic.main.fragment_weather.*
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class WeatherFragment : Fragment(R.layout.fragment_weather) {
    private val weatherViewModel by lazy {
        ViewModelProviders.of(this).get(WeatherViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchWeather()
        observeLiveData()
    }

    private fun fetchWeather() {
        weatherViewModel.fetchWeather(
            "Nairobi,ke",
            "metric",
            com.androidstudy.devfest19.BuildConfig.openMapApiKey
        )
    }

    private fun observeLiveData() {
        weatherViewModel.getWeatherResponse().nonNull().observe(this) { weatherResponseModel ->
            setupViews(weatherResponseModel)
        }
        weatherViewModel.getWeatherError().nonNull().observe(this) {
            activity?.toast(it)
        }
    }

    private fun setupViews(weatherResponseModel: WeatherResponseModel) {
        address.text = "${weatherResponseModel.name},${weatherResponseModel.sys.country}"
        status.text = weatherResponseModel.weather[0].description
        temp.text = "${weatherResponseModel.main.temp} °C"
        temp_min.text = "Min Temp: ${weatherResponseModel.main.temp_min}°C"
        temp_max.text = "Max Temp: ${weatherResponseModel.main.temp_max}°C"
        wind.text = weatherResponseModel.wind.speed.toString()
        pressure.text = weatherResponseModel.main.pressure.toString()
        humidity.text = weatherResponseModel.main.humidity.toString()

    }
}