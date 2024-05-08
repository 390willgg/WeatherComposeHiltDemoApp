package com.example.weathercomposedemoapp.data.repository.city.dataSourceImpl

import com.example.weathercomposedemoapp.data.api.server.ApiServiceWA
import com.example.weathercomposedemoapp.data.model.format.CityWeatherData
import com.example.weathercomposedemoapp.data.model.weatherAPI.toCityWeatherData
import com.example.weathercomposedemoapp.data.repository.city.dataSource.CityListRemoteDataSource
import com.example.weathercomposedemoapp.domain.repository.BaseRepository
import com.example.weathercomposedemoapp.domain.repository.getRetrofitService
import okhttp3.OkHttpClient

private class WACityListRemoteDataSourceImpl(
    private val client: OkHttpClient
): CityListRemoteDataSource, BaseRepository {
    private val baseUrl = "https://weatherapi-com.p.rapidapi.com/"
    private val service by lazy {
        return@lazy getRetrofitService(ApiServiceWA::class.java, baseUrl, client)
    }

    override suspend fun getCities(cityName: String, limit: Int): CityWeatherData? {
        val response = service?.getCityWeatherData(cityName)
        return response?.toCityWeatherData()
    }
}

fun getWACityListRemoteDataSourceImpl(client: OkHttpClient): CityListRemoteDataSource {
    return WACityListRemoteDataSourceImpl(client)
}