package com.example.weathercomposedemoapp.data.model.aiMeteoSource

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("angle")
    val angle: Int?,
    @SerializedName("dir")
    val dir: String?,
    @SerializedName("gusts")
    val gusts: Double?,
    @SerializedName("speed")
    val speed: Double?
)
