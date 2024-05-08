package com.example.weathercomposedemoapp.data.repository.weather

import android.util.Log
import com.example.weathercomposedemoapp.data.model.format.CurrentWeatherData
import com.example.weathercomposedemoapp.data.model.format.ForecastWeatherData
import com.example.weathercomposedemoapp.data.repository.weather.dataSource.WeatherRemoteDataSource
import com.example.weathercomposedemoapp.data.repository.weather.dataSourceImpl.getOWWeatherRemoteDataSourceImpl
import com.example.weathercomposedemoapp.domain.repository.WeatherRepository
import okhttp3.OkHttpClient

private class OWWeatherRepositoryImpl : WeatherRepository {
    private val apiKey ="49cac901dfcef84ab95c1c3d792d9a04"
    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            requestBuilder.addHeader("Authorization", "Bearer $apiKey")

            val request = requestBuilder.build()
            chain.proceed(request)
        }
        .build()

    private val weatherRemoteDataSource: WeatherRemoteDataSource =
        getOWWeatherRemoteDataSourceImpl(client)

    override suspend fun getCurrentWeatherData(
        lat: Double,
        lon: Double,
        units: String
    ): CurrentWeatherData? {
        Log.d("Repository", "Using OWWeatherRepository for getCurrentWeatherData")
        return weatherRemoteDataSource.getCurrentWeather(lat, lon, units)
    }

    override suspend fun getForecastWeatherData(
        lat: Double,
        lon: Double,
        units: String
    ): ForecastWeatherData? {
        Log.d("Repository", "Using OWWeatherRepository for getForecastWeatherData")
        return weatherRemoteDataSource.getForecast(lat, lon, units)
    }
}

fun getOWWeatherRepositoryImpl(): WeatherRepository {
    Log.d("Repository", "Creating OWWeatherRepository")
    return OWWeatherRepositoryImpl()
}