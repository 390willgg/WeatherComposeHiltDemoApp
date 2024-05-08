package com.example.weathercomposedemoapp.domain.repository

import com.example.weathercomposedemoapp.data.model.format.CityWeatherData

//@CityListScope
interface CityRepository {
    suspend fun getCitiesList(cityName: String, limit: Int): CityWeatherData?
}
