package com.example.weathercomposedemoapp.data.model.aiMeteoSource

import com.google.gson.annotations.SerializedName

data class Precipitation(
    @SerializedName("total")
    val total: Double?,
    @SerializedName("type")
    val type: String?
)
