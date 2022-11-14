package com.irv205.weatherappcompose.data.model

import com.google.gson.annotations.SerializedName

data class ForecastResponseDTO(
    val cod: String,
    val message: String,
    val cnt: Int,
    @SerializedName("list")
    val listL: List<ForecastDTO>,
    val city: CityDTO
)