package com.example.weathercomposedemoapp.data.model.openWeather.forecastResponse

import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("pod") val pod: String?
)
