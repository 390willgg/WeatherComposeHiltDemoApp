package com.example.weathercomposedemoapp.data.api.server

import com.example.weathercomposedemoapp.data.model.openWeather.CityResponseApiOW
import com.example.weathercomposedemoapp.data.model.openWeather.currentResponse.CurrentResponseApiOW
import com.example.weathercomposedemoapp.data.model.openWeather.forecastResponse.ForecastResponseApiOW
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceOW {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") apiKey: String
    ): CurrentResponseApiOW

    @GET("data/2.5/forecast")
    suspend fun getForecastWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") apiKey: String
    ): ForecastResponseApiOW

    @GET("geo/1.0/direct")
    fun getCitiesList(
        @Query("q") cityName: String,
        @Query("limit") limit: Int,
        @Query("appid") apiKey: String
    ): CityResponseApiOW
}
