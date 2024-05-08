package com.example.weathercomposedemoapp.data.model

data class ForecastDailyData(
    val date: String,
    val maxTemp: Double?,
    val minTemp: Double?,
    val weatherIcon: String?
)

