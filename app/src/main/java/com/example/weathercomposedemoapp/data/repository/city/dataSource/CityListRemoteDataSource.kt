package com.example.weathercomposedemoapp.data.repository.city.dataSource

import com.example.weathercomposedemoapp.data.model.format.CityWeatherData

interface CityListRemoteDataSource {
    suspend fun getCities(cityName: String, limit: Int): CityWeatherData?
}