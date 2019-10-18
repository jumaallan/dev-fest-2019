package com.androidstudy.weather.ui.views.ui.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.androidstudy.weather.R

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weatherr)

        setUpNavigation()
    }

    private fun setUpNavigation() {
        Navigation.findNavController(this, R.id.navHostFragment)
    }
}
