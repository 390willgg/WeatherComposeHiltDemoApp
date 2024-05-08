package com.example.weathercomposedemoapp.data.model.openWeather.forecastResponse

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h") val h: Double?
)

