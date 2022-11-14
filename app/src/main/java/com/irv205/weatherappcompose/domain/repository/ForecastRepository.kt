package com.irv205.weatherappcompose.domain.repository

import com.irv205.weatherappcompose.domain.DomainResponse
import com.irv205.weatherappcompose.domain.DomainWeather

interface ForecastRepository {
    suspend fun getForecast(city: String): DomainResponse<List<DomainWeather>>
}