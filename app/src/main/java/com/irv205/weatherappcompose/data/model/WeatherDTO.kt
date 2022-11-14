package com.irv205.weatherappcompose.data.model

data class WeatherDTO(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)