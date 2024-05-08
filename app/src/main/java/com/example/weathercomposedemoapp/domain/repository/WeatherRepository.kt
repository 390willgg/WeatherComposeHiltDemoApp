package com.example.weathercomposedemoapp.domain.repository

import com.example.weathercomposedemoapp.data.model.format.CurrentWeatherData
import com.example.weathercomposedemoapp.data.model.format.ForecastWeatherData


//@WeatherScope
interface WeatherRepository {
    suspend fun getCurrentWeatherData(lat: Double, lon: Double, units: String): CurrentWeatherData?
    suspend fun getForecastWeatherData(
        lat: Double,
        lon: Double,
        units: String
    ): ForecastWeatherData?
}




