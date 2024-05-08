package com.example.weathercomposedemoapp.data.repository.weather.dataSource

import com.example.weathercomposedemoapp.data.model.format.CurrentWeatherData
import com.example.weathercomposedemoapp.data.model.format.ForecastWeatherData

interface WeatherRemoteDataSource {
    suspend fun getCurrentWeather(lat: Double, lon: Double, units: String): CurrentWeatherData?
    suspend fun getForecast(lat: Double, lon: Double, units: String): ForecastWeatherData?
}

