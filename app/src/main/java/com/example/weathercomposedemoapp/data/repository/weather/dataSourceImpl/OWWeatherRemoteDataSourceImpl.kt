package com.example.weathercomposedemoapp.data.repository.weather.dataSourceImpl

import com.example.weathercomposedemoapp.data.api.server.ApiServiceOW
import com.example.weathercomposedemoapp.data.model.format.CurrentWeatherData
import com.example.weathercomposedemoapp.data.model.format.ForecastWeatherData
import com.example.weathercomposedemoapp.data.model.openWeather.currentResponse.toCurrentWeatherData
import com.example.weathercomposedemoapp.data.model.openWeather.forecastResponse.toForecastWeatherData
import com.example.weathercomposedemoapp.data.repository.weather.dataSource.WeatherRemoteDataSource
import com.example.weathercomposedemoapp.domain.repository.BaseRepository
import com.example.weathercomposedemoapp.domain.repository.getRetrofitService
import okhttp3.OkHttpClient

private class OWWeatherRemoteDataSourceImpl(
    client: OkHttpClient
) : WeatherRemoteDataSource, BaseRepository {
    private val service by lazy {
        return@lazy getRetrofitService(
            ApiServiceOW::class.java, "https://api.openweathermap.org/", client
        )

    }

    override suspend fun getCurrentWeather(
        lat: Double, lon: Double, units: String
    ): CurrentWeatherData? {
        val response = service?.getCurrentWeatherData(
            lat, lon, units,"49cac901dfcef84ab95c1c3d792d9a04"
        )
        return response?.toCurrentWeatherData()
    }

    override suspend fun getForecast(
        lat: Double, lon: Double, units: String
    ): ForecastWeatherData? {
        val response = service?.getForecastWeather(
            lat, lon, units, "49cac901dfcef84ab95c1c3d792d9a04"
        )
        return response?.toForecastWeatherData()
    }
}

fun getOWWeatherRemoteDataSourceImpl(client: OkHttpClient): WeatherRemoteDataSource {
    return OWWeatherRemoteDataSourceImpl(client)
}