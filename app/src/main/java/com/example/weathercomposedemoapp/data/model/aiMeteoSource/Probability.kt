package com.example.weathercomposedemoapp.data.model.aiMeteoSource

import com.google.gson.annotations.SerializedName

data class Probability(
    @SerializedName("freeze")
    val freeze: Int?,
    @SerializedName("precipitation")
    val precipitation: Int?,
    @SerializedName("storm")
    val storm: Int?
)