package com.example.weathercomposedemoapp.data.model.openWeather.forecastResponse

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all") val all: Int?
)

