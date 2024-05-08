package com.example.weathercomposedemoapp.domain.useCase.weather

import com.example.weathercomposedemoapp.data.model.format.CurrentWeatherData
import com.example.weathercomposedemoapp.data.model.format.ForecastWeatherData

interface WeatherUseCase {
    suspend fun getCurrentWeather(lat: Double, lon: Double, units: String): CurrentWeatherData?
    suspend fun getForecastWeather(lat: Double, lon: Double, units: String): ForecastWeatherData?
}