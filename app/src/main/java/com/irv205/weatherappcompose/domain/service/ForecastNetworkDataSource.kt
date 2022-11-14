package com.irv205.weatherappcompose.domain.service

import com.irv205.weatherappcompose.domain.DomainResponse
import com.irv205.weatherappcompose.domain.DomainWeather

interface ForecastNetworkDataSource {
    suspend fun getForecast(city: String): DomainResponse<List<DomainWeather>>
}