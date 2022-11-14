package com.irv205.weatherappcompose.data.model

import com.google.gson.annotations.SerializedName

data class MainInfoDTO(
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_kf")
    val temKf: Double
)