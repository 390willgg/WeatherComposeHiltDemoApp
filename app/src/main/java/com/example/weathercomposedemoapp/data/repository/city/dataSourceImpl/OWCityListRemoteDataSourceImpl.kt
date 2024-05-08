package com.example.weathercomposedemoapp.data.repository.city.dataSourceImpl

import com.example.weathercomposedemoapp.data.api.server.ApiServiceOW
import com.example.weathercomposedemoapp.data.model.format.CityWeatherData
import com.example.weathercomposedemoapp.data.model.openWeather.toCityWeatherData
import com.example.weathercomposedemoapp.data.repository.city.dataSource.CityListRemoteDataSource
import com.example.weathercomposedemoapp.domain.repository.BaseRepository
import com.example.weathercomposedemoapp.domain.repository.getRetrofitService
import okhttp3.OkHttpClient

private class OWCityListRemoteDataSourceImpl(
    client: OkHttpClient
) : CityListRemoteDataSource, BaseRepository {
    private val service by lazy {
        return@lazy getRetrofitService(
            ApiServiceOW::class.java,
            "https://api.openweathermap.org/",
            client
        )
    }

    override suspend fun getCities(cityName: String, limit: Int): CityWeatherData? {
        val response = service?.getCitiesList(
            cityName,
            limit,
            "49cac901dfcef84ab95c1c3d792d9a04"
        )
        return response?.toCityWeatherData()
    }
}

fun getOWCityListRemoteDataSourceImpl(client: OkHttpClient): CityListRemoteDataSource {
    return OWCityListRemoteDataSourceImpl(client)
}