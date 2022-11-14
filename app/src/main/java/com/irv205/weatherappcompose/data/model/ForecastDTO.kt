package com.irv205.weatherappcompose.data.model

import com.google.gson.annotations.SerializedName
import com.irv205.weatherappcompose.domain.DomainWeather

class ForecastDTO(
    @SerializedName("main")
    val main: MainInfoDTO,
    val weather: List<WeatherDTO>
){
    fun toDomainWeather(city: String) : DomainWeather {

        val weather = this.weather.firstOrNull()?.main ?: "Weather Empty"
        val weatherDescription = this.weather.firstOrNull()?.description ?:  "Description Empty"

        return DomainWeather(
            city,
            this.main.temp.toString(),
            weather,
            weatherDescription,
            this.main.feelsLike.toString()
        )
    }
}

