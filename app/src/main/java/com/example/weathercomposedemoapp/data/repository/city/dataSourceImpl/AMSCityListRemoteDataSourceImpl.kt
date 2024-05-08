package com.example.weathercomposedemoapp.data.repository.city.dataSourceImpl

import com.example.weathercomposedemoapp.data.api.server.ApiServiceAMS
import com.example.weathercomposedemoapp.data.model.aiMeteoSource.cityResponse.toCityWeatherData
import com.example.weathercomposedemoapp.data.model.format.CityWeatherData
import com.example.weathercomposedemoapp.data.repository.city.dataSource.CityListRemoteDataSource
import com.example.weathercomposedemoapp.domain.repository.BaseRepository
import com.example.weathercomposedemoapp.domain.repository.getRetrofitService
import okhttp3.OkHttpClient

private class AMSCityListRemoteDataSourceImpl(
    private val client: OkHttpClient
) : CityListRemoteDataSource, BaseRepository {
    val baseUrl = "https://ai-weather-by-meteosource.p.rapidapi.com/"
    private val service by lazy {
        return@lazy getRetrofitService(ApiServiceAMS::class.java, baseUrl, client)
    }

    override suspend fun getCities(cityName: String, limit: Int): CityWeatherData {
        return service?.getCitiesWeatherData(cityName, "en")?.toCityWeatherData()
            ?: throw Exception("Service error to get cities data from AMS")
    }
}

fun getAMSCityListRemoteDataSourceImpl(client: OkHttpClient): CityListRemoteDataSource {
    return AMSCityListRemoteDataSourceImpl(client)
}