package com.example.weathercomposedemoapp.domain.useCase.weather

import com.example.weathercomposedemoapp.data.model.format.CurrentWeatherData
import com.example.weathercomposedemoapp.data.model.format.ForecastWeatherData
import com.example.weathercomposedemoapp.domain.repository.WeatherRepository

private class WeatherUseCaseImpl(private val repository: WeatherRepository) :
    WeatherUseCase {
    override suspend fun getCurrentWeather(
        lat: Double, lon: Double, units: String
    ): CurrentWeatherData? {
        return repository.getCurrentWeatherData(lat, lon, units)
    }

    override suspend fun getForecastWeather(
        lat: Double, lon: Double, units: String
    ): ForecastWeatherData? {
        return repository.getForecastWeatherData(lat, lon, units)
    }
}

fun getWeatherUseCaseImpl(repository: WeatherRepository): WeatherUseCase =
    WeatherUseCaseImpl(repository)