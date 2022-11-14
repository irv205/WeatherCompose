package com.irv205.weatherappcompose.data.networkdatasource.service

import com.irv205.weatherappcompose.data.model.ForecastResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String = ""
    ): ForecastResponseDTO
}