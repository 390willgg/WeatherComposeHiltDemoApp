package com.example.weathercomposedemoapp.domain.useCase.city

import com.example.weathercomposedemoapp.data.model.format.CityWeatherData


interface CitiesListUseCase {
    suspend fun getCitiesList(cityName: String, limit: Int): CityWeatherData?
}