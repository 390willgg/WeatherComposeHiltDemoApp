package com.example.weathercomposedemoapp.domain.useCase.city

import com.example.weathercomposedemoapp.data.model.format.CityWeatherData
import com.example.weathercomposedemoapp.domain.repository.CityRepository

private class CitiesListUseCaseImpl (private val repository: CityRepository) :
    CitiesListUseCase {
    override suspend fun getCitiesList(cityName: String, limit: Int): CityWeatherData? {
        return repository.getCitiesList(cityName, limit)
    }
}

fun getCitiesListUseCaseImpl(repository: CityRepository): CitiesListUseCase =
    CitiesListUseCaseImpl(repository)

