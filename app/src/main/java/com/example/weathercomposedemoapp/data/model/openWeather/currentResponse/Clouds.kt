package com.example.weathercomposedemoapp.data.model.openWeather.currentResponse

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all") val all: Int?
)