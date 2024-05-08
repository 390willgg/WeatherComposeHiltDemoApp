package com.example.weathercomposedemoapp.data.repository.weather

import android.util.Log
import com.example.weathercomposedemoapp.data.model.format.CurrentWeatherData
import com.example.weathercomposedemoapp.data.model.format.ForecastWeatherData
import com.example.weathercomposedemoapp.data.repository.weather.dataSource.WeatherRemoteDataSource
import com.example.weathercomposedemoapp.data.repository.weather.dataSourceImpl.getWAWeatherRemoteDataSourceImpl
import com.example.weathercomposedemoapp.domain.repository.WeatherRepository
import okhttp3.OkHttpClient

private class WAWeatherRepositoryImpl : WeatherRepository {
    private val apiKey = "2ecdf6cfe5msh105a2f4e752782fp12c102jsnfc8c7fda92cc"
    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.addHeader("X-RapidAPI-Key", apiKey)
        requestBuilder.addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")

        val request = requestBuilder.build()
        chain.proceed(request)
    }.build()

    private val weatherRemoteDataSource: WeatherRemoteDataSource =
        getWAWeatherRemoteDataSourceImpl(client)

    override suspend fun getCurrentWeatherData(
        lat: Double, lon: Double, units: String
    ): CurrentWeatherData? {
        Log.d("Repository", "Using WAWeatherRepository for getCurrentWeatherData")
        return weatherRemoteDataSource.getCurrentWeather(lat, lon, units)
    }

    override suspend fun getForecastWeatherData(
        lat: Double, lon: Double, units: String
    ): ForecastWeatherData? {
        Log.d("Repository", "Using WAWeatherRepository for getForecastWeatherData")
        return weatherRemoteDataSource.getForecast(lat, lon, units)
    }
}

fun getWAWeatherRepositoryImpl(): WeatherRepository {
    Log.d("Repository", "Creating WAWeatherRepository")
    return WAWeatherRepositoryImpl()
}