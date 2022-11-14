package com.irv205.weatherappcompose.data.networkdatasource

import com.irv205.weatherappcompose.data.networkdatasource.service.WeatherService
import com.irv205.weatherappcompose.domain.DomainResponse
import com.irv205.weatherappcompose.domain.DomainWeather
import com.irv205.weatherappcompose.domain.service.ForecastNetworkDataSource
import javax.inject.Inject

class ForecastNetworkDataSourceImp @Inject constructor(private val service: WeatherService):
    ForecastNetworkDataSource {

    override suspend fun getForecast(city: String): DomainResponse<List<DomainWeather>> {
        val response = service.getForecast(city)
        return DomainResponse.Success(response.listL.map {
            it.toDomainWeather(response.city.name)
        })
    }
}