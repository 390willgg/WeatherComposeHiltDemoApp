package com.example.weathercomposedemoapp.data.model.aiMeteoSource.forecastResponse

import com.example.weathercomposedemoapp.data.model.aiMeteoSource.Data
import com.google.gson.annotations.SerializedName

data class Daily(
    @SerializedName("data") val `data`: List<Data?>?
)